package com.state.before;

/**
 * 2.
 * 电梯类（ILift的子实现类）
 */
public class Lift implements ILift{

    //声明一个记录当前电梯状态的一个变量
    private int state;
    @Override
    public void setState(int state) {
        this.state = state;
    }

    @Override
    public void open() {
        switch (state) {//当前电梯状态
            case OPENING_STATE:
                //什么事都不做
                break;
            case CLOSING_STATE:
                System.out.println("电梯打开了。。。");
                //设置当前电梯状态为开启
                setState(OPENING_STATE);
                break;
            case RUNNING_STATE:
                //什么事都不做
                break;
            case STOPPING_STATE:
                System.out.println("电梯打开了。。。");
                //设置当前电梯状态为开启
                setState(OPENING_STATE);
                break;
        }
    }

    @Override
    public void close() {
        switch (state) {//当前电梯状态
            case OPENING_STATE:
                System.out.println("电梯关闭了。。。");
                //设置当前电梯状态为关闭
                setState(CLOSING_STATE);
                break;
            case CLOSING_STATE:
                //什么事都不做
                break;
            case RUNNING_STATE:
                //运行时电梯门是关着的 不能关门
                break;
            case STOPPING_STATE:
                //什么事都不做
                break;
        }
    }

    @Override
    public void run() {
        switch (state) {//当前电梯状态
            case OPENING_STATE:
                //电梯开着门不能走
                break;
            case CLOSING_STATE:
                System.out.println("电梯开始运行了。。。");
                //设置当前电梯状态为运行
                setState(RUNNING_STATE);
                break;
            case RUNNING_STATE:
                //已经是运行中了
                break;
            case STOPPING_STATE:
                System.out.println("电梯开始运行了。。。");
                //设置当前电梯状态为运行
                setState(RUNNING_STATE);
                break;
        }
    }

    @Override
    public void stop() {
        switch (state) {//当前电梯状态
            case OPENING_STATE:
                //电梯开着门一般就是停止状态了
                break;
            case CLOSING_STATE:
                System.out.println("电梯停止了。。。");
                //设置当前电梯状态为停止
                setState(STOPPING_STATE);
                break;
            case RUNNING_STATE:
                System.out.println("电梯停止了。。。");
                setState(STOPPING_STATE);
                break;
            case STOPPING_STATE:
                break;
        }
    }
}
