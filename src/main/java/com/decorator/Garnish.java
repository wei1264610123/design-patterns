package com.decorator;

/**
 * 3.装饰着类
 * 抽象装饰者角色
 */
public abstract class Garnish extends FastFood {

    //声明快餐类的变量
    private FastFood fastFood;

    public FastFood getFastFood() {
        return fastFood;
    }

    public void setFastFood(FastFood fastFood) {
        this.fastFood = fastFood;
    }


    public Garnish(float price, String desc, FastFood fastFood) {
        super(price, desc);
        this.fastFood = fastFood;
    }
}
