package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.dto.IngredientDto;

public interface IngredientConverter {
    IngredientDto convertToIngredientDto(Ingredient ingredient);
    Ingredient convertToIngredient(IngredientDto ingredientDto);
}
