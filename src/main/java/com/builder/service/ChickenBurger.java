package com.builder.service;

public class ChickenBurger extends Burger{
    @Override
    public float price() {
        return 50.0f;
    }

    @Override
    public String name() {
        return "鸡肉汉堡：Chicken Burger";
    }
}
