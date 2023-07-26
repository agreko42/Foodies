package com.foodies.backend.recipeLogic.dbConnection;

import com.foodies.backend.recipeLogic.FlavourType;
import com.foodies.backend.security.user.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {

    @Id
    @GeneratedValue
    private long id;
    private String name;

    @ElementCollection
    List<String> steps;
    @ElementCollection
    List<String> comments;
    FlavourType flavourType;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "recipe_ingredients",
    joinColumns = {@JoinColumn(name = "recipe_id")},
    inverseJoinColumns = {@JoinColumn(name = "ingredient_id")})
    private Set<Ingredient> ingredients = new HashSet<>();

   /*
    @ManyToOne
    @JoinColumn(name = "_user_id")
    private User user;

    */

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//TODO: same structure as for recipes (interface, entity etc.) but for ingredients, then integrate both into endpoints
    public List<String> getSteps() {
        return steps;
    }

    public void setSteps(List<String> steps) {
        this.steps = steps;
    }

    public List<String> getComments() {
        return comments;
    }

    public void setComments(List<String> comments) {
        this.comments = comments;
    }

    public FlavourType getFlavourType() {
        return flavourType;
    }

    public void setFlavourType(FlavourType flavourType) {
        this.flavourType = flavourType;
    }
    /*
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

     */
}
