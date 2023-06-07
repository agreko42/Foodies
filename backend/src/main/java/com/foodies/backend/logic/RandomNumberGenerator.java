package com.foodies.backend.logic;

import java.util.Random;

public class RandomNumberGenerator {

    private final Random random;

    public RandomNumberGenerator() {
        this.random = new Random();
    }

    public int getRandomNumber(int start, int end) {
        return random.nextInt(start, end);
    }
}
