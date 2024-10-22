package com.adapter.class_adapter;

/**
 * 适配者类
 */
public class TFCardImpl implements TFCard{
    @Override
    public String readTF() {
        return "读取数据HELLO WORD TF CARD";
    }

    @Override
    public void writeTF(String msg) {
        System.out.println("TFCard write: " + msg);
    }
}
