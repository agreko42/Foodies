package com.foodies.backend.logic;

import com.foodies.backend.data.MenuType;
import com.foodies.backend.service.FoodListStorageService;

public class MealChooser {
    private FoodListStorageService foodlists;
    private Service services;
    private RandomNumberGenerator randomNumberGenerator;

    public MealChooser(FoodListStorageService foodlists, Service services, RandomNumberGenerator randomNumberGenerator) {
        this.foodlists = foodlists;
        this.services = services;
        this.randomNumberGenerator = randomNumberGenerator;
    }


    public String getRandomDishByUserChoice(String choice){
        String choiceString = choice.toLowerCase();
        System.out.println(choiceString);
        //java: Muster in Switch-Anweisungen sind ein Vorschaufeature, das standardmäßig deaktiviert ist.
        //  (Verwenden Sie --enable-preview, um Muster in Switch-Anweisungen zu aktivieren)
        String breakfast = MenuType.SWEET.getMenuType();
        String lunch = MenuType.SEVERY.getMenuType();
        switch(choiceString){
            case("sweet"): // TODO: Instead of hardcoding the strings here, do enums or constants in interfaces
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.SWEET));
            case("severy"):
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.SEVERY));
            default:
                return "No valid category chosen";
        }
    }
}
