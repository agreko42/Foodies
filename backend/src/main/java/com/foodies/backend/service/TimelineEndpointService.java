package com.foodies.backend.service;

import com.foodies.backend.DTO.RecipeResponse;
import com.foodies.backend.data.RecipeRepository;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;


@Service
@RequiredArgsConstructor
public class TimelineEndpointService {

    private final UserRepository userRepository;
    private final RecipeRepository recipeRepository;
    private final DtoService dtoService;
    public List<RecipeResponse> getTimelineForUser(String username) {
        return userRepository.findByUsername(username).get().getUserFollowing()
                .stream()
                .flatMap( user ->
                        recipeRepository.findRecipesByUser_Username(user.getUsername())
                                .stream())
                .map(dtoService::convertRecipeToRecipeResponse)
                .sorted(Comparator.comparing(RecipeResponse::getPostedOn))
                .toList();

    }
}
