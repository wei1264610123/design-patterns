package com.builder.demo;

public class Client {
    public static void main(String[] args) {
        //创建指挥者对象
        Director director = new Director(new HaLuoBuilder());
        //让指挥者组装自行车
        Bike construct = director.construct();
        System.out.println(construct.getFrame() + "----" + construct.getSeat());

        Builder builder = new MeiTuanBuilder();
//        Bike construct1 = builder.construct();
//        System.out.println(construct1.getFrame() + construct1.getSeat());
    }
}
