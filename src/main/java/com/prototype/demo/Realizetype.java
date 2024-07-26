package com.prototype.demo;

public class Realizetype implements Cloneable{

    public Realizetype() {
        System.out.println("通过new对象进行创建！");
    }

    @Override
    public Realizetype clone() throws CloneNotSupportedException {
        System.out.println("具体原型复制完成！");
        return (Realizetype) super.clone();
    }
}
