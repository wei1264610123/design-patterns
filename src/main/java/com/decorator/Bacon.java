package com.decorator;

/**
 * 4.配料 培根类
 * 具体的装饰者角色
 */
public class Bacon extends Garnish {

    public Bacon(FastFood fastFood) {
        super(2, "培根二块钱", fastFood);
    }

    @Override
    public float cost() {
        //计算价格
        return getPrice() + getFastFood().cost();
    }

    @Override
    public String getDesc() {
        return super.getDesc() + getFastFood().getDesc();
    }
}
