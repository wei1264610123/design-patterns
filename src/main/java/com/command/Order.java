package com.command;

import java.util.HashMap;
import java.util.Map;

/**
 * 1.订单类
 *
 */
public class Order {
    //餐桌号码
    private int diningTable;


    //餐品及份数
    private Map<String, Integer> foodDir = new HashMap<String, Integer>();

    public int getDiningTable() {
        return diningTable;
    }

    public void setDiningTable(int diningTable) {
        this.diningTable = diningTable;
    }

    public Map<String, Integer> getFoodDir() {
        return foodDir;
    }

    public void setFoodDir(String name, Integer num) {
        foodDir.put(name, num);
    }
}
