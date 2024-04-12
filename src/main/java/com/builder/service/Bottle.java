package com.builder.service;

/**
 * 瓶子 类
 */
public class Bottle implements Packing{
    @Override
    public String pack() {
        return "瓶子-bottle";
    }
}
