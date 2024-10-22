package com.bridge;

/**
 * 桥接模式
 */
public class Client {
    public static void main(String[] args) {
        //创建mac系统对象
        OpSystem opSystem = new Mac(new AviFile());
        //使用操作系统播放视频文件
        opSystem.play("战狼3");
    }
}
