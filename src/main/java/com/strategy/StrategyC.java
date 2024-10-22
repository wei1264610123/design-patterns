package com.strategy;

/**
 * 2.具体策略类
 */
public class StrategyC implements Strategy{

    @Override
    public void show() {
        System.out.println("满1000元加一元换购任意200以下商品");
    }
}
