package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.RecipeDto;

public interface RecipeConverter {
    RecipeDto convertToRecipeDto(Recipe recipe);
    Recipe convertToRecipe(RecipeDto recipeDto);
}
