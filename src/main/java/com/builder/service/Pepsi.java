package com.builder.service;

public class Pepsi extends ColdDrink{
    @Override
    public float price() {
        return 35.0f;
    }

    @Override
    public String name() {
        return "百世可乐";
    }
}
