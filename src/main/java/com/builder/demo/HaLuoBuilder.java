package com.builder.demo;

/**
 * 具体的构建者 用来构建哈啰单车对象
 */
public class HaLuoBuilder extends Builder{
    @Override
    public void buildFrame() {
        bike.setFrame("铝制车架");
    }

    @Override
    public void buildSeat() {
        bike.setSeat("橡胶车座");
    }

    @Override
    public Bike createBike() {
        return bike;
    }
}
