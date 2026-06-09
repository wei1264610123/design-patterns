package com.iterator;

/**
 * 行为型模式
 * 迭代器模式
 */
public class Client {
    public static void main(String[] args) {
        // 先创建聚合对象
        StudentAggregateImpl aggregate = new StudentAggregateImpl();
        //添加元素
        aggregate.addStudent(new Student("张山", "001"));
        aggregate.addStudent(new Student("李四", "002"));
        aggregate.addStudent(new Student("王五", "003"));
    }
}
