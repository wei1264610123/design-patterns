package com.proxy.static_proxy;

/**
 * 代理类
 * 代售点类
 */
public class ProxyPoint implements SellTickets{
    /**
     * 聚合对象操作
     * 声明火车站类对象
     */
    private TrainStation trainStation = new TrainStation();

    @Override
    public void sell() {
        System.out.println("代理收取一点服务费用");
        trainStation.sell();
    }
}
