package com.iterator;

/**
 * 4.抽象聚合角色接口
 */
public interface StudentAggregate {
    //添加学生功能
    void addStudent(Student student);

    //删除学生功能
    void removeStudent(Student student);

    //获取迭代器功能
    StudentIterator getStudentIterator();
}
