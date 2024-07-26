package com.builder.demo;

public abstract class Builder {

    //声明Bike类型的变量，并进行赋值
    protected Bike bike = new Bike();

    //构建车架
    public abstract void buildFrame();

    //构建车座
    public abstract void buildSeat();

    //构建自行车
    public abstract Bike createBike();

    //如果不建指挥者类 可以在这组装自行车 如果组装操作较麻烦 最好还是新建指挥者类 Director
    /*public Bike construct() {
        buildFrame();
        buildSeat();
        return createBike();
    }*/

}
