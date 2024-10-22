package com.responsibility;

/**
 * 2.
 * 抽象处理着类
 */
public abstract class Handler {
    //请假天数
    protected final static int NUM_ONE = 1;
    protected final static int NUM_THREE = 3;
    protected final static int NUM_SEVEN = 7;

    //该领导处理的请假天数区间
    private int numStart;
    private int numEnd;

    //声明后继者（声明上级领导）
    private Handler nextHandler;

    public Handler(int numStart) {
        this.numStart = numStart;
    }

    public Handler(int numStart, int numEnd) {
        this.numStart = numStart;
        this.numEnd = numEnd;
    }

    //设置上级领导对象
    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    //各级领导处理请假条的方法
    protected abstract void handlerLeave(LeaveRequest leave);

    //提交请假条
    public final void submit(LeaveRequest leave) {

        if (nextHandler != null && leave.getNum() > this.numEnd) {
            //超过了审批范围权限 提交给上级领导
            this.nextHandler.submit(leave);
        } else {
            //改领导先进行审批
            this.handlerLeave(leave);
            System.out.println("流程结束");
        }
    }

}
