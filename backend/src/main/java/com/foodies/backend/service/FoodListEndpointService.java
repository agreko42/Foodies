package com.foodies.backend.service;

import com.foodies.backend.data.Dish;
import com.foodies.backend.data.MenuType;
import com.foodies.backend.logic.MealChooser;
import com.foodies.backend.recipeLogic.dbConnection.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public class FoodListEndpointService {

    private final FoodListStorageService foodListStorageService;
    private final MealChooser mealChooser;

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

    public List<Dish> getSweetDishes(){
        return foodListStorageService.getDishesByType(MenuType.SWEET);
    }

    public List<Dish> getSeveryDishes(){
        return foodListStorageService.getDishesByType(MenuType.SEVERY);
    }

    public List<Dish> addSweetDishAndShowAllLists(@RequestBody Dish dish){
        return foodListStorageService.addDish(dish, MenuType.SWEET);
    }

    public List<Dish> addSeveryAndShowDinnerList(@RequestBody Dish dish){
        return foodListStorageService.addDish(dish, MenuType.SEVERY);
    }

}
