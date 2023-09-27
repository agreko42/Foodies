package com.foodies.backend.service;

import com.foodies.backend.DTO.CommentRequest;
import com.foodies.backend.DTO.RecipeCommentDTO;
import com.foodies.backend.data.Recipe;
import com.foodies.backend.data.RecipeComment;
import com.foodies.backend.data.RecipeCommentRepository;
import com.foodies.backend.data.RecipeRepository;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentEndpointService {

    private final DtoService dtoService;
    private final RecipeCommentRepository commentRepository;
    private final RecipeRepository recipeRepository;
    private final UserRepository userRepository;

    public List<RecipeCommentDTO> getCommentsForRecipe(Long recipeId) {
        return commentRepository.findRecipeCommentsByRecipeId(recipeId)
                .stream()
                .map(dtoService::convertRecipeCommentToDto)
                .collect(Collectors.toList());
    }

    public RecipeCommentDTO postComment(Long recipeId, String username, CommentRequest request){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        Recipe recipe = recipeRepository.findById(recipeId)
                .orElseThrow( () -> new RuntimeException("Recipe not found"));
        RecipeComment comment = new RecipeComment(request.getContent(), user, recipe, LocalDateTime.now());
        return dtoService.convertRecipeCommentToDto(commentRepository.save(comment));
    }
}
