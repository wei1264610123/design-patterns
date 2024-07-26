package com.builder.demo;

/**
 * 具体的构建者 用来构建美团单车对象
 */
public class MeiTuanBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("碳钎维车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("真皮车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
