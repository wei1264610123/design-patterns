package com.decorator;

import java.io.BufferedWriter;

/**
 * 装饰者模式
 */
public class Client {
    public static void main(String[] args) {
        FastFood food = new FriedRice();
        System.out.println(food.getDesc() + "------" + food.cost());

        System.out.println("=======================");
        //在上面的炒饭中加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + "------" + food.cost());
        System.out.println("=======================");
        //在加一个鸡蛋
        food = new Egg(food);
        System.out.println(food.getDesc() + "------" + food.cost());
        System.out.println("=======================");
        //在加一个培根
        food = new Bacon(food);
        System.out.println(food.getDesc() + "------" + food.cost());

    }
}
