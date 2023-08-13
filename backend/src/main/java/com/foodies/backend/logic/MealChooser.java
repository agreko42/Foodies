package com.foodies.backend.logic;

import com.foodies.backend.data.MenuType;
import com.foodies.backend.service.FoodListStorageService;

public class MealChooser {
    private FoodListStorageService foodlists;
    private RandomizerService services;
    private RandomNumberGenerator randomNumberGenerator;

    public MealChooser(FoodListStorageService foodlists, RandomizerService services, RandomNumberGenerator randomNumberGenerator) {
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
        String lunch = MenuType.SAVOURY.getMenuType();
        switch(choiceString){
            case("sweet"):
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.SWEET));
            case("savoury"):
                return services.getRandomMeal(foodlists.getDishesByType(MenuType.SAVOURY));
            default:
                return "No valid category chosen";
        }
    }
}
