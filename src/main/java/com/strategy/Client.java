package com.strategy;


/**
 * 策略模式
 */
public class Client {
    public static void main(String[] args) {
        //春节来了，展示促销活动
        SalesMan salesMan = new SalesMan(new StrategyA());
        salesMan.salesManShow();

        System.out.println("=======================================");
        //中秋节到了
        salesMan = new SalesMan(new StrategyB());
        salesMan.salesManShow();

        System.out.println("=======================================");
        //圣诞节到了
        salesMan = new SalesMan(new StrategyC());
        salesMan.salesManShow();
    }
}
