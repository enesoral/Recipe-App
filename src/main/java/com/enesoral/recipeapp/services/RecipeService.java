package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
