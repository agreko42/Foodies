package com.foodies.backend.recipeLogic;

import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import com.foodies.backend.recipeLogic.dbConnection.RecipeRepository;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class RecipeEndpointService {
    private final RecipeRepository repository;


    public List<Recipe> getRecipesByFlavourType(String type) {
        String typeString = type.toLowerCase();
        String case1 = FlavourType.SWEET.getType();
        String case2 = FlavourType.SAVOURY.getType();

        if(typeString.equalsIgnoreCase(case1)){
            return repository.findByFlavourType(FlavourType.SWEET);
        }
        else if (typeString.equalsIgnoreCase(case2)) {
            return repository.findByFlavourType(FlavourType.SAVOURY);
        }
        else{
            return repository.findAll();
        }
    }

    public Recipe postRecipe(Recipe recipe) {
         return repository.save(recipe);
    }
}
