package com.adapter.object_adapter;

/**
 * 对象适配器模式
 * 对象的比较好
 */
public class Client {
    public static void main(String[] args) {
        //创建计算机对象
        Computer computer = new Computer();
        //读取sd卡中的数据
        String msg = computer.readSD(new SDCardImpl());
        System.out.println(msg);

        System.out.println("=================================");
        //使用该计算机 读取tf卡中的数据
        //创建适配器类对象
        String msg1 = computer.readSD(new SDAdapterTF(new TFCardImpl()));
        System.out.println(msg1);

    }
}
