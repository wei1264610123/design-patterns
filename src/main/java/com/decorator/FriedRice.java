package com.decorator;

/**
 * 2.炒饭类
 * 具体构建角色
 */
public class FriedRice extends FastFood{

    public FriedRice() {
        super(10, "炒饭");
    }
    @Override
    public float cost() {
        return getPrice();
    }
}
