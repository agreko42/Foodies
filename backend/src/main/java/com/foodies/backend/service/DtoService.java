package com.foodies.backend.service;

import com.foodies.backend.DTO.IngredientDTO;
import com.foodies.backend.DTO.RecipeCommentDTO;
import com.foodies.backend.DTO.RecipeRequest;
import com.foodies.backend.DTO.RecipeResponse;
import com.foodies.backend.data.Ingredient;
import com.foodies.backend.data.Recipe;
import com.foodies.backend.data.RecipeComment;
import com.foodies.backend.security.user.User;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class DtoService {

    public RecipeResponse convertRecipeToRecipeResponse(Recipe recipe) {
        RecipeResponse recipeResponse = new RecipeResponse();
        recipeResponse .setId(recipe.getId());
        recipeResponse .setName(recipe.getName());
        recipeResponse .setSteps(recipe.getSteps());
        recipeResponse .setComments(recipe.getComments());
        recipeResponse .setFlavourType(recipe.getFlavourType());
        recipeResponse .setIngredients(recipe.getIngredients().stream().map(this::convertIngredientToDto).collect(Collectors.toSet()));
        recipeResponse .setUserName(recipe.getUser().getUsername());
        recipeResponse .setPostedOn(recipe.getTimestamp());

        return recipeResponse;
    }

    private IngredientDTO convertIngredientToDto(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAmount(ingredient.getAmount());
        ingredientDTO.setUnit(ingredient.getUnit());

        return ingredientDTO;
    }

    public Recipe convertRecipeRequestToRecipe(RecipeRequest recipeRequest, User user) {
        Recipe recipe = new Recipe();
        if(recipeRequest.getId() != null) {
            recipe.setId(recipeRequest.getId());
        }
        recipe.setName(recipeRequest.getName());
        recipe.setSteps(recipeRequest.getSteps());
        recipe.setComments(recipeRequest.getComments());
        recipe.setFlavourType(recipeRequest.getFlavourType());
        recipe.setIngredients(recipeRequest.getIngredients().stream()
                .map(this::convertDtoToIngredient)
                .collect(Collectors.toSet()));
        recipe.setUser(user);

        return recipe;
    }

    public Ingredient convertDtoToIngredient(IngredientDTO ingredientDTO) {
        Ingredient ingredient = new Ingredient();
        if(ingredientDTO.getId() != null) {
            ingredient.setId(ingredientDTO.getId());
        }
        ingredient.setId(ingredientDTO.getId());
        ingredient.setName(ingredientDTO.getName());
        ingredient.setAmount(ingredientDTO.getAmount());
        ingredient.setUnit(ingredientDTO.getUnit());

        return ingredient;
    }

    public RecipeCommentDTO convertRecipeCommentToDto(RecipeComment comment){
        return new RecipeCommentDTO(comment.getContent(), comment.getTimestamp(), comment.getUser().getUsername());

    }
}
