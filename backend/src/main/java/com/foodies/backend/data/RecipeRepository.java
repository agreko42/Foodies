package com.foodies.backend.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    Recipe findById(long id);
    List<Recipe> findByFlavourType(FlavourType type);
    List<Recipe> findRecipesByUserId(Long id);
    List<Recipe> findRecipesByUser_Username(String username);
}
