package com.foodies.backend.recipeLogic;



import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeEndpoint {

    private final RecipeEndpointService recipeService;

    @GetMapping("/{type}")
    public List<Recipe> getRecipesByFlavourType(@PathVariable String type){
            return recipeService.getRecipesByFlavourType(type);
    }

    @PostMapping("/post")
    public Recipe postRecipe(@RequestBody Recipe recipe){
        return recipeService.postRecipe(recipe);
    }
}

