package com.foodies.backend.service;

import com.foodies.backend.DTO.IngredientDTO;
import com.foodies.backend.DTO.RecipeRequest;
import com.foodies.backend.DTO.RecipeResponse;
import com.foodies.backend.data.FlavourType;
import com.foodies.backend.data.Ingredient;
import com.foodies.backend.data.Recipe;
import com.foodies.backend.data.RecipeRepository;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RecipeEndpointService {
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;



    public List<RecipeResponse> getRecipesByFlavourType(String type) {
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

    public RecipeResponse getRecipe(Long id){
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe could not be found"));
        return convertToDTO(recipe);
    }

    public List<RecipeResponse > findRecipesByUserId(Long userId){
        List<Recipe> recipes = recipeRepository.findRecipesByUserId(userId);
        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public List<RecipeResponse> findRecipesByUser_Username(String username){
        List<Recipe> recipes = recipeRepository.findRecipesByUser_Username(username);
        System.out.println("recipes: " + recipes);
        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    private RecipeResponse convertToDTO(Recipe recipe) {
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

    public List<RecipeResponse> getAllRecipes() {
        List<Recipe> recipes = recipeRepository.findAll();
        return recipes.stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    public RecipeResponse postRecipe(RecipeRequest recipeRequest, String username) {
        Recipe recipe = convertToRecipeEntity(recipeRequest, username);
        recipe.setTimestamp(LocalDateTime.now());
        Recipe savedRecipe = recipeRepository.save(recipe);
        return convertToDTO(savedRecipe);
    }

    public RecipeResponse updateRecipe(Long id, RecipeRequest recipeRequest) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recipe with id " + id + " not found"));

        recipe.setName(recipeRequest.getName());
        recipe.setSteps(recipeRequest.getSteps());
        recipe.setComments(recipeRequest.getComments());
        recipe.setFlavourType(recipeRequest.getFlavourType());

        Set<Ingredient> updatedIngredients = recipeRequest.getIngredients().stream()
                .map(this::convertDtoToIngredient)
                .collect(Collectors.toSet());

        recipe.setIngredients(updatedIngredients);

        Recipe updatedRecipe = recipeRepository.save(recipe);
        return convertToDTO(updatedRecipe);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }

    private Recipe convertToRecipeEntity(RecipeRequest recipeRequest, String username) {
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
        User user = userRepository.findByUsername(username)
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
