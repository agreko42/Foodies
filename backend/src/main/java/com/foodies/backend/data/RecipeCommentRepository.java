package com.foodies.backend.data;

import com.foodies.backend.security.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeCommentRepository extends JpaRepository<RecipeComment, Long> {
    List<RecipeComment> findRecipeCommentsByUser(User user);
    List<RecipeComment> findRecipeCommentsByRecipeId(Long recipeId);
}
