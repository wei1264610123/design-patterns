package com.prototype;

public class Square extends Shape{

    public Square() {
        type = "Square(正方形)";
    }
    @Override
    void draw() {
        System.out.println("里面 正方形::draw() 方法.");
    }
}
