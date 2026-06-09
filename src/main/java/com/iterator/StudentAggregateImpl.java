package com.iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.具体的聚合角色实现类
 */
public class StudentAggregateImpl implements StudentAggregate{
    private List<Student> studentList = new ArrayList<Student>();
    @Override
    public void addStudent(Student student) {
        studentList.add(student);
    }

    @Override
    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    @Override
    public StudentIterator getStudentIterator() {
        return new StudentIteratorImpl(studentList);
    }
}
