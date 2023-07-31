package com.foodies.backend.recipeLogic;



import com.foodies.backend.recipeLogic.dbConnection.Recipe;
import com.foodies.backend.recipeLogic.dbConnection.RecipeDTO;
import com.foodies.backend.security.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeEndpoint {

    private final RecipeEndpointService recipeService;

    @GetMapping("/{type}")
    public List<RecipeDTO> getRecipesByFlavourType(@PathVariable String type){
            return recipeService.getRecipesByFlavourType(type);
    }

    @GetMapping("/units")
    public List<UnitEnum> getUnits() {
        return List.of(UnitEnum.values());
    }

    @GetMapping("/list")
    public ResponseEntity<List<RecipeDTO>> getAllRecipes() {
        List<RecipeDTO> recipes = recipeService.getAllRecipes();
        return ResponseEntity.ok(recipes);
    }

    @GetMapping("/recipe/{id}")
    public ResponseEntity<RecipeDTO> getRecipe(@PathVariable Long id) {
        RecipeDTO recipe = recipeService.getRecipe(id);
        return ResponseEntity.ok(recipe);
    }

    @GetMapping("/user/{userId}")
    public List<RecipeDTO> getRecipesByUser(@PathVariable Long userId){ //String username für Frontend wegen token
        return recipeService.findRecipesByUserId(userId);
    }


    @PostMapping("/post")
    public ResponseEntity<RecipeDTO> postRecipe(@RequestBody RecipeDTO recipeDTO) {
        RecipeDTO savedRecipe = recipeService.postRecipe(recipeDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRecipe);
    }

}

