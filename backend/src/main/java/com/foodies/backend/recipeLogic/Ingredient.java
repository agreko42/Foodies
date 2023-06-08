package com.foodies.backend.recipeLogic;

import com.foodies.backend.recipeLogic.UnitEnum;

public record Ingredient (double amount, UnitEnum unit, String name)  {
}
