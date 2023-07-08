package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue()
    private long recipeId;
    private String name;

    private long ownerId;
    @ElementCollection
    List<String> steps;
    @ElementCollection
    List<String> comments;
    FlavourType flavourType;
    @OneToMany(mappedBy="recipe")
    private List<Ingredient> ingredients;


    protected Recipe (){}

    public long getRecipeId() {
        return recipeId;
    }

    public long getOwnerId() {
        return ownerId;
    }

    public String getName() {
        return name;
    }

   // public List<Ingredient> getIngredients() {
  //      return ingredients;
  //  }
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

    public List<Ingredient> getIngredients() {
        return ingredients;
    }
}
