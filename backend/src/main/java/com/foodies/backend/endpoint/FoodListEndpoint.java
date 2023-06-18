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

    @GetMapping("/sweet")
    public List<Dish> getSweetDishes(){
        return foodListEndpointService.getSweetDishes();
    }

    @GetMapping("/severy")
    public List<Dish> getSeveryDishes(){
        return foodListEndpointService.getSeveryDishes();
    }

    @PostMapping("/add-sweet")
    public List<Dish> addSweetDishAndShowAllLists(@RequestBody Dish dish){
        return foodListEndpointService.addSweetDishAndShowAllLists(dish);
    }

    @PostMapping("/add-severy")
    public List<Dish> addSeveryAndShowDinnerList(@RequestBody Dish dish){
        return foodListEndpointService.addSeveryAndShowDinnerList(dish);
    }

}
