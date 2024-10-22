package com.adapter.class_adapter;

/**
 * 适配器类
 */
public class SDAdapterTF extends TFCardImpl implements SDCard{
    @Override
    public String readSD() {
        System.out.println("适配器 read TFCard");
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("适配器 write TFCard");
        writeTF(msg);
    }
}
