package com.foodies.backend.logic;

import com.foodies.backend.data.Dish;

import java.util.List;

public class Service {

    private final RandomNumberGenerator randomNumberGenerator;

    public Service(RandomNumberGenerator randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getRandomMeal(List<Dish> foodlist){
        return foodlist.get(getRandomNumber(0, foodlist.size())).getName();
    }

    private int getRandomNumber(int minRange, int maxRange) {
        return randomNumberGenerator.getRandomNumber(minRange, maxRange);
        //return random.nextInt(maxRange - minRange) + minRange;
    }
}
