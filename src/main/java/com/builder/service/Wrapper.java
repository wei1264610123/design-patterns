package com.builder.service;

/**
 * 包装纸 类
 */
public class Wrapper implements Packing{

    @Override
    public String pack() {
        return "包装纸-wrapper";
    }
}