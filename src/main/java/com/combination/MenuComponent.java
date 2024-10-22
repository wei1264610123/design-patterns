package com.combination;

/**
 * 1.菜单组件
 * 抽象根节点
 */
public abstract class MenuComponent {
    protected String name; //菜单组件的名称

    protected int level; //菜单层级

    //添加子菜单
    public void add(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    //移除子菜单
    public void remove(MenuComponent menuComponent) {
        throw new UnsupportedOperationException();
    }

    //获取指定的子菜单
    public MenuComponent getChild(int index) {
        throw new UnsupportedOperationException();
    }

    //获取菜单或菜单项的名称
    public String getName() {
        return name;
    }

    //打印菜单名称的方法 (包含子菜单和子菜单项)
    public abstract void print();


}
