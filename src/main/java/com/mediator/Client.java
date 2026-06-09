package com.mediator;

/**
 *行为型模式
 * 中介者模式
 */
public class Client {
    public static void main(String[] args) {
        //创建中介者对象
        MediatorStructure mediatorStructure = new MediatorStructure();

        //创建俩个同事类对象
        //创建租房者对象
        Tenant tenant = new Tenant("李四", mediatorStructure);

        //创建房主对象
        HouseOwner houseOwner = new HouseOwner("张三", mediatorStructure);

        //中介者要知道具体的房主和租房者
        mediatorStructure.setTenant(tenant);
        mediatorStructure.setHouseOwner(houseOwner);

        tenant.constact("听说你那有三居室的房子要出租！！！");
        houseOwner.constact("我这里有三室的房子你要租吗？");
    }
}
