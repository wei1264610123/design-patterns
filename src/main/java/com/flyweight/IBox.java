package com.flyweight;

/**
 * 2. IBox 图形类
 * 具体享元角色
 */
public class IBox extends AbstractBox {
    @Override
    public String getShape() {
        return "I";
    }
}
