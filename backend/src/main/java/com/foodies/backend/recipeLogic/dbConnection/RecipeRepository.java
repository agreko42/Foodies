package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findById(long id);
    List<Recipe> findByFlavourType(FlavourType type);
}
