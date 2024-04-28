package com.prototype;

/**
 * 创建扩展了上面抽象类的实体类 矩形
 */
public class Rectangle extends Shape{

    public Rectangle() {
        type = "Rectangle(矩形)";
    }
    @Override
    void draw() {
        System.out.println("里面 矩形::draw() 方法.");
    }
}
