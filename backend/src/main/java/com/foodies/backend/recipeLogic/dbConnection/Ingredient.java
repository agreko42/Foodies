package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.UnitEnum;
import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private double amount;
    private UnitEnum unit;
    private String name;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "ingredients")
    private Set<Recipe> recipes = new HashSet<>();

    public Set<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(Set<Recipe> recipes) {
        this.recipes = recipes;
    }
}
