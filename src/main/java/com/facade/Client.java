package com.facade;

/**
 * 外观模式
 */
public class Client {
    public static void main(String[] args) {
        SmartAppliancesFacade smartAppliancesFacade = new SmartAppliancesFacade();
        smartAppliancesFacade.say("打开电灯");

        smartAppliancesFacade.say("关闭");
    }
}
