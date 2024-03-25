package com.rafaelsantos.recipes.services;

import com.rafaelsantos.recipes.models.Recipe;
import com.rafaelsantos.recipes.models.User;

import java.util.List;

public interface RecipeService {

    public List<Recipe> findAllRecipes();
    public Recipe findRecipeById(Long id) throws Exception;
    public Recipe createRecipe(Recipe recipe, User user);
    public Recipe updateRecipe(Recipe recipe, Long id) throws Exception;
    public void deleteRecipe(Long id) throws Exception;
    public Recipe likeRecipe(Long recipeId, User user) throws Exception;
}
