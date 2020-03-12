package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.RecipeDto;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeDto saveRecipeDto(RecipeDto recipeDto);
    RecipeDto findDtoById(Long l);
}
