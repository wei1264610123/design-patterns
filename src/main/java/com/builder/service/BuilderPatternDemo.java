package com.builder.service;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        meal.showItems();
        System.out.println("Total Cost: " +meal.getCost());


        Meal nonVegMeal = mealBuilder.prepareNotVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        System.out.println("Total Cost: " +nonVegMeal.getCost());


        Meal twoBurgerMeal = mealBuilder.twoBurgerMeal();
        System.out.println("\n\nNon-Veg Meal");
        twoBurgerMeal.showItems();
        System.out.println("Total Cost: " +twoBurgerMeal.getCost());
    }
}
