package com.foodies.backend.DTO;


import com.foodies.backend.data.FlavourType;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class RecipeResponse {

    private Long id;
    private String userName;
    private String name;
    private List<String> steps;
    private List<String> comments;
    private FlavourType flavourType;
    private Set<IngredientDTO> ingredients;
    private LocalDateTime postedOn;

    public RecipeResponse(Long id, String userName, String name, List<String> steps, List<String> comments, FlavourType flavourType, Set<IngredientDTO> ingredients, LocalDateTime postedOn) {
        this.id = id;
        this.userName = userName;
        this.name = name;
        this.steps = steps;
        this.comments = comments;
        this.flavourType = flavourType;
        this.ingredients = ingredients;
        this.postedOn = postedOn;
    }

    public RecipeResponse() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public LocalDateTime getPostedOn() {
        return postedOn;
    }

    public void setPostedOn(LocalDateTime postedOn) {
        this.postedOn = postedOn;
    }
}
