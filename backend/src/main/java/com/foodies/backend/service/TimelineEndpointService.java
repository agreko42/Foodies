package com.foodies.backend.service;

import com.foodies.backend.DTO.RecipeResponse;
import com.foodies.backend.data.RecipeRepository;
import com.foodies.backend.security.user.User;
import com.foodies.backend.security.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
