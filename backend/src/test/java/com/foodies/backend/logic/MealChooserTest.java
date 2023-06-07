package com.foodies.backend.logic;

import com.foodRoulette.service.FoodListStorage;
import org.mockito.Mockito;

import java.util.Random;

class MealChooserTest {
    private FoodListStorage lists = Mockito.mock(FoodListStorage.class);
    private Random random = new Random();

    /*
    @Test
    void getRandomDishByUserChoice() {
        Mockito.when(lists.getBreakfast()).thenReturn(List.of(new Dish("BreakfastBacon")));
        Mockito.when(lists.getLunch()).thenReturn(List.of(new Dish("LunchMeat")));
        Mockito.when(lists.getDinner()).thenReturn(List.of(new Dish("ChickenDinner")));

        MealChooser chooser = new MealChooser(lists, new Service(randomNumberGenerator));

        assertEquals("BreakfastBacon", chooser.getRandomDishByUserChoice("Breakfast"));
        assertEquals("LunchMeat", chooser.getRandomDishByUserChoice("Lunch"));
        assertEquals("ChickenDinner", chooser.getRandomDishByUserChoice("Dinner"));
    }

     */
}