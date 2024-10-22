package com.strategy;

/**
 * 2.具体策略类
 */
public class StrategyB implements Strategy{

    @Override
    public void show() {
        System.out.println("买200减50");
    }
}
