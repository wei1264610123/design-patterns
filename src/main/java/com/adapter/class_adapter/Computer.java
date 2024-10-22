package com.adapter.class_adapter;

/**
 * 计算机
 */
public class Computer {
    //从SD卡中读取数据
    public String readSD(SDCard sdCard) {
        if (null == sdCard) {
            throw  new NullPointerException("sd card is not null");
        }
        return sdCard.readSD();
    }
}
