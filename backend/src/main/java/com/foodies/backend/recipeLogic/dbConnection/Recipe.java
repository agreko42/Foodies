package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;
import com.foodies.backend.recipeLogic.Ingredient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    private long ownerId;

    @ElementCollection
    List<String> steps;
    @ElementCollection
    List<String> comments;
    FlavourType flavourType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_ingredients",
    joinColumns = {@JoinColumn(name = "recipe_id")},
    inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

//TODO: same structure as for recipes (interface, entity etc.) but for ingredients, then integrate both into endpoints
    public List<String> getSteps() {
        return steps;
    }

    public List<String> getComments() {
        return comments;
    }

    public FlavourType getFlavourType() {
        return flavourType;
    }
}
