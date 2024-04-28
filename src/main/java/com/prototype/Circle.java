package com.prototype;

public class Circle extends Shape{

    public Circle() {
        type = "Circle(圆形)";
    }
    @Override
    void draw() {
        System.out.println("里面 圆形::draw() 方法.");
    }
}
