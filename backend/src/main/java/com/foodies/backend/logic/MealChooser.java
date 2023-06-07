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
        String breakfast = MenuType.BREAKFAST.getMenuType();
        String lunch = MenuType.LUNCH.getMenuType();
        String dinner = MenuType.DINNER.getMenuType();
        switch(choiceString){
            case("breakfast"): // TODO: Instead of hardcoding the strings here, do enums or constants in interfaces
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.BREAKFAST));
            case("lunch"):
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.LUNCH));
            case("dinner"):
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.DINNER));
            default:
                return "No valid category chosen";
        }
    }
}
