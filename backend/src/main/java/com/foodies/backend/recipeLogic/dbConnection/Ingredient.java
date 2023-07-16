package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.UnitEnum;
import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

@Entity
@AllArgsConstructor
public class Ingredient {
    @ManyToOne
    @JoinColumn(name="recipeId", nullable=false)
    private Recipe recipe;
    @Id
    @GeneratedValue()
    private long ingredientId;
    private double amount;
    private UnitEnum unit;
    private String name;

    protected Ingredient(){};

    public Recipe getRecipe() {
        return recipe;
    }

    public long getIngredientId() {
        return ingredientId;
    }

    public double getAmount() {
        return amount;
    }

    public UnitEnum getUnit() {
        return unit;
    }

    public String getName() {
        return name;
    }
}
