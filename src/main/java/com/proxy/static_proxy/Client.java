package com.proxy.static_proxy;

public class Client {
    public static void main(String[] args) {
        //创建代理类对象
        ProxyPoint proxyPoint = new ProxyPoint();
        //调用方法进行买票
        proxyPoint.sell();
    }
}
