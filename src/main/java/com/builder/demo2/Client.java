package com.builder.demo2;

public class Client {
    public static void main(String[] args) {
        //通过构建者对象获取手机对象
        Phone build = new Phone.Builder()
                .cpu("英特尔cpu")
                .screen("三星屏幕")
                .memory("金士顿内存条")
                .mainboard("华硕主板")
                .build();
        System.out.println(build);
    }
}
