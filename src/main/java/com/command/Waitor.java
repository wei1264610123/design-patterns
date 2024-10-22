package com.command;

import java.util.ArrayList;
import java.util.List;

/**
 * 5.服务员类
 * 请求者角色
 */
public class Waitor {
    //持有多个命令类角色
    private List<Command> commandList = new ArrayList<Command>();

    public void setCommand(Command cmd) {
        commandList.add(cmd);
    }

    //发起命令的方法 喊 订单来了
    public void orderUp() {
        System.out.println("服务员说：大厨，新订单来了。。。");
        //便利list集合
        for (Command command : commandList) {
            if (null != command) {
                command.execute();
            }
        }
    }
}
