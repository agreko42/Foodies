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

    public long postRecipe(postRecipeRequest request) {
        System.out.println("post is tried -----------------------------------------");
        Recipe recipe = new Recipe(1,
                request.getName(),
                request.getOwnerId(),
                request.getSteps(),
                request.getComments(),
                FlavourType.valueOf(request.getFlavourType()));
        System.out.println(recipe.getName());
        System.out.println(recipe.getFlavourType().getType());
       return repository.save(recipe).getId();
    }
}
