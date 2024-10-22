package com.responsibility;

public class Client {
    public static void main(String[] args) {
        //创建请假条对象
        LeaveRequest leaveRequest = new LeaveRequest("张三", 8, "有事回家");
        LeaveRequest leaveRequest2 = new LeaveRequest("张三", 1, "有事回家");
        LeaveRequest leaveRequest3 = new LeaveRequest("张三", 3, "有事回家");
        //创建各级领导对象
        GroupLeader groupLeader = new GroupLeader();
        Manager manager = new Manager();
        GeneralManager generalManager = new GeneralManager();


        //设置处理者链
        groupLeader.setNextHandler(manager);
        manager.setNextHandler(generalManager);

        //提交请假申请
        System.out.println("===================================");
        groupLeader.submit(leaveRequest);
        System.out.println("===================================");
        groupLeader.submit(leaveRequest2);
        System.out.println("===================================");
        groupLeader.submit(leaveRequest3);
        System.out.println("===================================");
    }
}
