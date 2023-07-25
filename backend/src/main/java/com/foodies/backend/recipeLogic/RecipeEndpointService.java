package com.foodies.backend.recipeLogic;

import com.foodies.backend.recipeLogic.dbConnection.Ingredient;
import com.foodies.backend.recipeLogic.dbConnection.IngredientRepository;
import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import com.foodies.backend.recipeLogic.dbConnection.RecipeRepository;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class RecipeEndpointService {
    private final RecipeRepository recipeRepository;
    private final IngredientRepository ingredientRepository;


    public List<Recipe> getRecipesByFlavourType(String type) {
        String typeString = type.toLowerCase();
        String case1 = FlavourType.SWEET.getType();
        String case2 = FlavourType.SAVOURY.getType();

        if(typeString.equalsIgnoreCase(case1)){
            return recipeRepository.findByFlavourType(FlavourType.SWEET);
        }
        else if (typeString.equalsIgnoreCase(case2)) {
            return recipeRepository.findByFlavourType(FlavourType.SAVOURY);
        }
        else{
            return recipeRepository.findAll();
        }
    }

    public Recipe postRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }
}
