package com.foodies.backend.configuration;

import com.foodies.backend.data.Dish;
import com.foodies.backend.data.Menu;
import com.foodies.backend.data.MenuType;
import com.foodies.backend.logic.MealChooser;
import com.foodies.backend.logic.RandomNumberGenerator;
import com.foodies.backend.logic.Service;
import com.foodies.backend.recipeLogic.RecipeEndpointService;
import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import com.foodies.backend.recipeLogic.dbConnection.RecipeRepository;
import com.foodies.backend.service.FoodListEndpointService;
import com.foodies.backend.service.FoodListStorage;
import com.foodies.backend.service.FoodListStorageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Configuration
public class BeansConfiguration {

    @Bean
    FoodListStorage FoodListLoader() {
        Menu sweet = new Menu(new ArrayList<>(
                List.of(new Dish("Cereal", "https://images.unsplash.com/photo-1504308805006-0f7a5f1f0f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3174&q=80"),
                        new Dish("Bacon&Eggs", "https://images.unsplash.com/photo-1608475861994-cf7af0f0c1be?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80"),
                        new Dish("Omelette", "https://images.unsplash.com/photo-1604242684508-c309e173a3e7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80"),
                        new Dish("Dry Toast", "https://images.unsplash.com/photo-1516226392000-3536759b78e7?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=2070&q=80"))), MenuType.SWEET);
        Menu savoury = new Menu(new ArrayList<>(
                List.of(new Dish("Pizza", "https://images.unsplash.com/photo-1504308805006-0f7a5f1f0f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3174&q=80"),
                        new Dish("Spaghetti", "https://images.unsplash.com/photo-1504308805006-0f7a5f1f0f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3174&q=80"),
                        new Dish("Burger", "https://images.unsplash.com/photo-1504308805006-0f7a5f1f0f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3174&q=80"),
                        new Dish("Sushi", "https://images.unsplash.com/photo-1504308805006-0f7a5f1f0f71?ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D&auto=format&fit=crop&w=3174&q=80"))), MenuType.SAVOURY);
        return new FoodListStorage(new ArrayList<>(List.of(sweet, savoury)));
    }

    @Bean
    FoodListStorageService foodListStorageService() {
        return new FoodListStorageService(FoodListLoader());
    }


    @Bean
    MealChooser mealChooserLoader() {
        return new MealChooser(foodListStorageService(), new Service(randomNumberGenerator()), randomNumberGenerator());
    }

    @Bean
    RandomNumberGenerator randomNumberGenerator() {
        return new RandomNumberGenerator();
    }

    @Bean
    FoodListEndpointService foodListEndpointService() {
        return new FoodListEndpointService(foodListStorageService(), mealChooserLoader());
    }

}
