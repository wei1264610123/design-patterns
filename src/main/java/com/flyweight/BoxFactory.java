package com.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 工厂类
 * 将该类设计为单例
 */
public class BoxFactory {

    private Map<String, AbstractBox> map;

    //在构造方法中进行初始化操作
    private BoxFactory() {
        map = new HashMap<String, AbstractBox>();
        map.put("I", new IBox());
        map.put("L", new LBox());
        map.put("O", new OBox());

    }

    //根据名称获取图形对象
    public AbstractBox getShape(String name) {
        return map.get(name);
    }


    //提供一个方法获取该工厂对象
    public static BoxFactory getInstance() {
        return boxFactory;
    }

    private static BoxFactory boxFactory = new BoxFactory();
}
