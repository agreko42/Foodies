package com.foodies.backend.recipeLogic;

import com.foodies.backend.recipeLogic.dbConnection.*;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserRepository;
import jakarta.persistence.GeneratedValue;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeEndpointService {
    private final RecipeRepository recipeRepository;


    public List<RecipeDTO> getRecipesByFlavourType(String type) {
        String typeString = type.toLowerCase();
        String case1 = FlavourType.SWEET.getType();
        String case2 = FlavourType.SAVOURY.getType();
        List<Recipe> recipes;

        if(typeString.equalsIgnoreCase(case1)){
            recipes = recipeRepository.findByFlavourType(FlavourType.SWEET);
        }
        else if (typeString.equalsIgnoreCase(case2)) {
            recipes = recipeRepository.findByFlavourType(FlavourType.SAVOURY);
        }
        else{
            recipes = recipeRepository.findAll();
        }

        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RecipeDTO getRecipe(Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe could not be found"));
        return convertToDTO(recipe);
    }

    public List<RecipeDTO> findRecipesByUserId(Long userId){
        List<Recipe> recipes = recipeRepository.findRecipesByUserId(userId);
        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RecipeDTO convertToDTO(Recipe recipe) {
        RecipeDTO recipeDTO = new RecipeDTO();
        recipeDTO.setId(recipe.getId());
        recipeDTO.setName(recipe.getName());
        recipeDTO.setSteps(recipe.getSteps());
        recipeDTO.setComments(recipe.getComments());
        recipeDTO.setFlavourType(recipe.getFlavourType());
        recipeDTO.setIngredients(recipe.getIngredients().stream().map(this::convertIngredientToDto).collect(Collectors.toSet()));
        recipeDTO.setUserId(recipe.getUser().getId());

        return recipeDTO;
    }

    private IngredientDTO convertIngredientToDto(Ingredient ingredient) {
        IngredientDTO ingredientDTO = new IngredientDTO();
        ingredientDTO.setId(ingredient.getId());
        ingredientDTO.setName(ingredient.getName());
        ingredientDTO.setAmount(ingredient.getAmount());
        ingredientDTO.setUnit(ingredient.getUnit());

        return ingredientDTO;
    }

    public List<RecipeDTO> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RecipeDTO postRecipe(RecipeDTO recipeDTO) {
        Recipe recipe = convertToRecipeEntity(recipeDTO);
        Recipe savedRecipe = recipeRepository.save(recipe);
        return convertToDTO(savedRecipe);
    }

    private Recipe convertToRecipeEntity(RecipeDTO recipeDTO) {
        Recipe recipe = new Recipe();
        if(recipeDTO.getId() != null) {
            recipe.setId(recipeDTO.getId());
        }
        recipe.setName(recipeDTO.getName());
        recipe.setSteps(recipeDTO.getSteps());
        recipe.setComments(recipeDTO.getComments());
        recipe.setFlavourType(recipeDTO.getFlavourType());
        recipe.setIngredients(recipeDTO.getIngredients().stream()
                .map(this::convertDtoToIngredient)
                .collect(Collectors.toSet()));
        User user = userRepository.findById(recipeDTO.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));
        recipe.setUser(user);

        return recipe;
    }

    private Ingredient convertDtoToIngredient(IngredientDTO ingredientDTO) {
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
}
