package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;

import java.util.List;
import java.util.Set;

public class RecipeDTO {

    private Long id;
    private Long userId;
    private String name;
    private List<String> steps;
    private List<String> comments;
    private FlavourType flavourType;
    private Set<IngredientDTO> ingredients;

    public RecipeDTO(Long id, String name, List<String> steps, List<String> comments, FlavourType flavourType, Set<IngredientDTO> ingredients) {
        this.id = id;
        this.name = name;
        this.steps = steps;
        this.comments = comments;
        this.flavourType = flavourType;
        this.ingredients = ingredients;
    }

    public RecipeDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public FlavourType getFlavourType() {
        return flavourType;
    }

    public void setFlavourType(FlavourType flavourType) {
        this.flavourType = flavourType;
    }

    public Set<IngredientDTO> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }
}
