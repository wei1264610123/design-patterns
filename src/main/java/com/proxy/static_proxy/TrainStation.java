package com.proxy.static_proxy;

/**
 * 具体主题类
 * 火车站类
 */
public class TrainStation implements SellTickets{

    @Override
    public void sell() {
        System.out.println("火车站卖票");
    }
}
