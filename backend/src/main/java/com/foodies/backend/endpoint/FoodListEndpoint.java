package com.foodies.backend.endpoint;

import com.foodies.backend.data.Dish;
import com.foodies.backend.service.FoodListEndpointService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/foodlist")
public class FoodListEndpoint {

    private final FoodListEndpointService foodListEndpointService;

    public FoodListEndpoint(FoodListEndpointService foodListEndpointService) {
        this.foodListEndpointService = foodListEndpointService;
    }

    @GetMapping
    public List<List<Dish>> readAllDishes(){
        return foodListEndpointService.readAllDishes();
    }

    @GetMapping("/chooseFood/{type}")
    public String getRandomDishByUserChoice(@PathVariable String type){
        return foodListEndpointService.getRandomDishByUserChoice(type);
    }

    @GetMapping("/breakfast")
    public List<Dish> getBreakfastDishes(){
        return foodListEndpointService.getBreakfastDishes();
    }

    @GetMapping("/dinner")
    public List<Dish> getDinnerDishes(){
        return foodListEndpointService.getDinnerDishes();
    }

    @GetMapping("/lunch")
    public List<Dish> getLunchDishes(){
        return foodListEndpointService.getLunchDishes();
    }

    @PostMapping("/add-breakfast")
    public List<Dish> addBreakfastDishAndShowAllLists(@RequestBody Dish dish){
        return foodListEndpointService.addBreakfastDishAndShowAllLists(dish);
    }

    @PostMapping("/add-dinner")
    public List<Dish> addDinnerAndShowDinnerList(@RequestBody Dish dish){
        return foodListEndpointService.addDinnerAndShowDinnerList(dish);
    }

    @PostMapping("/add-lunch")
    public List<Dish> addLaunchAndShowLunchList(@RequestBody Dish dish){
        return foodListEndpointService.addLaunchAndShowLunchList(dish);
    }
}
