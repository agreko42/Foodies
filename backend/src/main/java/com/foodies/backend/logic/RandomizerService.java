package com.foodies.backend.logic;

import com.foodies.backend.data.Dish;

import java.util.List;

public class RandomizerService {

    private final RandomNumberGenerator randomNumberGenerator;

    public RandomizerService(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getRandomMeal(List<Dish> foodlist){
        return foodlist.get(getRandomNumber(0, foodlist.size())).getName();
    }

    private int getRandomNumber(int minRange, int maxRange) {
        return randomNumberGenerator.getRandomNumber(minRange, maxRange);
    }
}
