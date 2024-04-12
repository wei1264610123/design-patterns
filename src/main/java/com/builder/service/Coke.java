package com.builder.service;

public class Coke extends ColdDrink{
    @Override
    public float price() {
        return 30.0f;
    }

    @Override
    public String name() {
        return "可口可乐：Coke";
    }
}
