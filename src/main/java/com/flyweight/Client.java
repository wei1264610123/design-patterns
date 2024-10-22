package com.flyweight;

import java.sql.SQLOutput;

/**
 * 享元模式
 */
public class Client {
    public static void main(String[] args) {
        AbstractBox iBox = BoxFactory.getInstance().getShape("I");
        iBox.display("grey");
        AbstractBox iBox2 = BoxFactory.getInstance().getShape("L");
        iBox2.display("blue");
        AbstractBox iBox3 = BoxFactory.getInstance().getShape("O");
        iBox3.display("red");
        AbstractBox iBox4 = BoxFactory.getInstance().getShape("O");
        iBox4.display("grey");

        System.out.println("判断对象创建的是不是同一个对象，" + (iBox3 == iBox4));
    }
}
