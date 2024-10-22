package com.command;

import java.util.Map;

/**
 * 4.具体的命令类
 */
public class OrderCommand implements Command{
    //持有接收者对象
    private SeniorChef seniorChef;

    private Order order;

    public OrderCommand(SeniorChef seniorChef, Order order) {
        this.seniorChef = seniorChef;
        this.order = order;
    }

    @Override
    public void execute() {
        System.out.println(order.getDiningTable() + "桌的订单：");
        Map<String, Integer> foodDir = order.getFoodDir();
        for (String foodName : foodDir.keySet()) {
            seniorChef.makeFood(foodName, foodDir.get(foodName));
        }
        System.out.println(order.getDiningTable() + "桌的饭准备完毕!!!");
    }
}
