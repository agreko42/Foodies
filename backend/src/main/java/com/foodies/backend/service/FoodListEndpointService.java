package com.foodies.backend.service;

import com.foodies.backend.data.Dish;
import com.foodies.backend.data.MenuType;
import com.foodies.backend.logic.MealChooser;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class FoodListEndpointService {

    private final FoodListStorageService foodListStorageService;
    private final MealChooser mealChooser;

    //TODO: export all the logic to a service and pass your objects to it CHECKED!!
    //This ensures that you do not need to touch the controller if a change is needed

    public FoodListEndpointService(FoodListStorageService foodListStorageService, MealChooser mealChooser) {
        this.foodListStorageService = foodListStorageService;
        this.mealChooser = mealChooser;
    }

    public List<List<Dish>> readAllDishes(){
        return foodListStorageService.getAllDishes();
    }

    public String getRandomDishByUserChoice(@PathVariable String type){
        return mealChooser.getRandomDishByUserChoice(type);
    }

    public List<Dish> getBreakfastDishes(){
        return foodListStorageService.getDishesByType(MenuType.BREAKFAST);
    }

    public List<Dish> getDinnerDishes(){

        return foodListStorageService.getDishesByType(MenuType.DINNER);
    }

    public List<Dish> getLunchDishes(){

        return foodListStorageService.getDishesByType(MenuType.LUNCH);
    }

    public List<Dish> addBreakfastDishAndShowAllLists(@RequestBody Dish dish){
        return foodListStorageService.addDish(dish, MenuType.BREAKFAST);
    }

    public List<Dish> addDinnerAndShowDinnerList(@RequestBody Dish dish){
        return foodListStorageService.addDish(dish, MenuType.DINNER);
    }

    public List<Dish> addLaunchAndShowLunchList(@RequestBody Dish dish){
        return foodListStorageService.addDish(dish, MenuType.LUNCH);
    }
}
