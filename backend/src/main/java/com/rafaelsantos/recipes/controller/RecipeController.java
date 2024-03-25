package com.rafaelsantos.recipes.controller;

import com.rafaelsantos.recipes.models.Recipe;
import com.rafaelsantos.recipes.models.User;
import com.rafaelsantos.recipes.services.RecipeService;
import com.rafaelsantos.recipes.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    @Autowired
    private UserService userService;

    @GetMapping("/api/recipes")
    public List<Recipe> getAllRecipes() {
        return recipeService.findAllRecipes();
    }
    @GetMapping("/api/recipes/{id}")
    public Recipe findRecipeById(@PathVariable Long id) throws Exception {
        return recipeService.findRecipeById(id);
    }

    @PostMapping("/api/recipes/user/{userId}")
    public Recipe createRecipe(@RequestBody Recipe recipe, @PathVariable Long userId) throws Exception {

        User user = userService.findUserById(userId);

        return recipeService.createRecipe(recipe, user);
    }

    @PutMapping("/api/recipes/{id}")
    public Recipe updateRecipe(@RequestBody Recipe recipe, @PathVariable Long id) throws Exception {

        return recipeService.updateRecipe(recipe, id);
    }

    @DeleteMapping ("/api/recipes/{recipeId}")
    public String deleteRecipe( @PathVariable Long recipeId) throws Exception {

        recipeService.deleteRecipe(recipeId);
        return "Recipe delete successfully";
    }

    @PutMapping("/api/recipes/{id}/user/{userId}")
    public Recipe likeRecipe(@PathVariable Long userId, @PathVariable Long id) throws Exception {

        User user = userService.findUserById(userId);

        return recipeService.likeRecipe(id, user);
    }
}
