package com.foodies.backend.service;

import com.foodies.backend.DTO.RecipeResponse;
import com.foodies.backend.data.Recipe;
import com.foodies.backend.data.RecipeRepository;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TimelineEndpointService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final DtoService dtoService;
    public List<RecipeResponse> getTimelineForUser(String username) {
        List<Recipe> followedUserRecipes = new ArrayList<>(userRepository.findByUsername(username).get().getUserFollowing()
                .stream()
                .flatMap( user ->
                        recipeRepository.findRecipesByUser_Username(user.getUsername())
                                .stream())
                .toList());

        List<Recipe> ownedRecipes = recipeRepository.findRecipesByUser_Username(username);

        followedUserRecipes.addAll(ownedRecipes);

        return followedUserRecipes.stream()
                .map(dtoService::convertRecipeToRecipeResponse)
                .sorted(Comparator.comparing(RecipeResponse::getPostedOn).reversed())
                .limit(100)
                .toList();


    }

    public List<RecipeResponse> getWholeTimeline() {
        return recipeRepository.getAll().stream()
                .map(dtoService::convertRecipeToRecipeResponse)
                .sorted(Comparator.comparing(RecipeResponse::getPostedOn).reversed())
                .toList();
    }
}
