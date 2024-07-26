package com.proxy.jdk_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 获取代理对象的工厂类
 * 代理类也实现了对应的接口
 */
public class ProxyFactory {

    //声明目标对象
    private TrainStation trainStation = new TrainStation();


    //获取代理对象
    public SellTickets getProxyObject() {
        SellTickets sellTickets = (SellTickets) Proxy.newProxyInstance(
                trainStation.getClass().getClassLoader(),
                trainStation.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     *
                     * @param proxy 代理对象 和sellTickets是同一个对象，在invoke方法中基本不用
                     *
                     * @param method 对接口中的方法进行封装的method对象  client中的 proxyObject.sell()
                     *
                     * @param args 调用方法的实际参数
                     *
                     * @return 方法的返回值
                     * @throws Throwable
                     */
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                        System.out.println("invoke方法执行了");
                        System.out.println("代售点收取一定的服务费用（jdk动态代理）");
                        //执行目标对象的方法
                        Object invoke = method.invoke(trainStation, args);
                        return invoke;
                    }
                }
        );
        return sellTickets;
    }
}
