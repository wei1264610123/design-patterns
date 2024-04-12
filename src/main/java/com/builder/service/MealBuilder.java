package com.builder.service;

public class MealBuilder {
    /**
     * 准备素食餐
     */
    public Meal prepareVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    /**
     *
     准备非素食餐
     */
    public Meal prepareNotVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }

    /**
     * 准备双汉堡餐
     */
    public Meal twoBurgerMeal() {
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new ChickenBurger());
        return meal;
    }
}
