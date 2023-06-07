package com.foodies.backend.service;

import com.foodies.backend.data.Dish;
import com.foodies.backend.data.Menu;
import com.foodies.backend.data.MenuType;

import java.util.ArrayList;
import java.util.List;

public class FoodListStorageService {

    private final FoodListStorage foodListStorage;

    public FoodListStorageService(FoodListStorage foodListStorage) {
        this.foodListStorage = foodListStorage;
    }

    //TODO: export next two functions to a service CHECKED! (War in FoodlistStorage drinnen)
    public List<List<Dish>> getAllDishes() {
        return new ArrayList(foodListStorage.menues().stream()
                .map(Menu::dishes)
                .toList());
    }

    public List<Dish> getDishesByType(MenuType menuType) {
        return foodListStorage.menues().stream()
                .filter(menu -> menu.menuType() == menuType)
                .map(Menu::dishes).flatMap(list -> list.stream()).toList();
    }

    public List<Dish> addDish(Dish dish, MenuType menuType) {
        return foodListStorage.menues().stream()
                .filter(menues -> menues.menuType() == menuType)
                .peek(menu -> menu.addDish(dish))
                .map(menu -> menu.dishes())
                .flatMap(list -> list.stream())
                .toList();
    }
}
