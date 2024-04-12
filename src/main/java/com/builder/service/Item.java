package com.builder.service;

/**
 * 餐食组合
 */
public interface Item {
    public String name();

    public Packing packing();

    public float price();
}