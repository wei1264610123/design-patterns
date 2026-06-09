package com.iterator;

import java.util.List;

/**
 * 具体的迭代器角色类
 */
public class StudentIteratorImpl implements StudentIterator{

    private List<Student> studentList;

    private int position = 0; //用来记录遍历时的位置

    public StudentIteratorImpl(List<Student> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean hasNext() {
        return position < studentList.size();
    }

    @Override
    public Student next() {
        //从集合中获取指定位置的元素
        Student student = studentList.get(position);
        position++;
        return student;
    }
}
