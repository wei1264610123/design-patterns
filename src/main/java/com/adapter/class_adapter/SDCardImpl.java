package com.adapter.class_adapter;

/**
 * 具体的SD卡类
 */
public class SDCardImpl implements SDCard{
    @Override
    public String readSD() {
        return "SDCard read msg: Hello word";
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("SDCard write msg: " + msg);
    }
}
