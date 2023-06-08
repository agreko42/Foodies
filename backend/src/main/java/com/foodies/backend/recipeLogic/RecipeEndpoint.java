package com.foodies.backend.recipeLogic;



import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:5173"})
@RequestMapping("/recipe")
@RequiredArgsConstructor
public class RecipeEndpoint {

    private final RecipeEndpointService recipeService;

    @GetMapping("/{type}")
    public String getRecipesByFlavourType(@PathVariable String type){
        try{
            return recipeService.getRecipesByFlavourType(type).toString();
        }
        catch(Exception e) {
            return e.getMessage();
        }
    }

    @PostMapping("/post")
    public ResponseEntity<Long> postRecipe(@RequestBody postRecipeRequest recipeRequest){
        long savedRecipeId = recipeService.postRecipe(recipeRequest);
        return  ResponseEntity.ok(savedRecipeId);
    }
}

