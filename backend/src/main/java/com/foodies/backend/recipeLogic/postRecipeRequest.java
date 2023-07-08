package com.foodies.backend.recipeLogic;

import com.foodies.backend.recipeLogic.dbConnection.Ingredient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class postRecipeRequest {
    String name;
    long ownerId;
    List<String> steps;
    List<String> comments;
    String flavourType;
    // TODO: does it work with private?
    List<Ingredient> ingredients;
}
