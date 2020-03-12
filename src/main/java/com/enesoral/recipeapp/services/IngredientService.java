package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.dto.IngredientDto;

public interface IngredientService {
    Ingredient findById(Long id);
    IngredientDto findDtoById(Long id);
    Ingredient saveIngredient(Ingredient ingredient);
    IngredientDto saveIngredientDto(IngredientDto ingredientDto);
    void deleteById(Long id);
}
