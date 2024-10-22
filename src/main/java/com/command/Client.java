package com.command;

public class Client {
    public static void main(String[] args) {
        //创建订单对象
        Order order1 = new Order();
        order1.setDiningTable(1);
        order1.setFoodDir("西红柿鸡蛋面", 1);
        order1.setFoodDir("小杯可乐", 2);

        Order order2 = new Order();
        order2.setDiningTable(2);
        order2.setFoodDir("尖椒肉丝盖饭", 1);
        order2.setFoodDir("小杯橙汁", 2);

        //创建接收者对象 厨师
        SeniorChef seniorChef = new SeniorChef();
        //创建命令对象
        OrderCommand orderCommand1 = new OrderCommand(seniorChef, order1);
        OrderCommand orderCommand2 = new OrderCommand(seniorChef, order2);

        //创建调用者对象 服务员
        Waitor waitor = new Waitor();
        waitor.setCommand(orderCommand1);
        waitor.setCommand(orderCommand2);

        //让服务员发起命令
        waitor.orderUp();
    }
}
