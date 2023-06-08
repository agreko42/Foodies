package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;
import com.foodies.backend.recipeLogic.Ingredient;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    private long ownerId;

   // @ElementCollection
   // List<Ingredient> ingredients;
    @ElementCollection
    List<String> steps;
    @ElementCollection
    List<String> comments;
    FlavourType flavourType;


    protected Recipe (){}

    public long getId() {
        return id;
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

    public List<String> getSteps() {
        return steps;
    }

    public List<String> getComments() {
        return comments;
    }
}
