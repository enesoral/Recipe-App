package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.domain.Note;
import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.CategoryDto;
import com.enesoral.recipeapp.dto.IngredientDto;
import com.enesoral.recipeapp.dto.NoteDto;
import com.enesoral.recipeapp.dto.RecipeDto;

public interface Converter {
    RecipeDto convertToRecipeDto(Recipe recipe);
    Recipe convertToRecipe(RecipeDto recipeDto);
    CategoryDto convertToCategoryDto(Category category);
    Category convertToCategory(CategoryDto categoryDto);
    IngredientDto convertToIngredientDto(Ingredient ingredient);
    Ingredient convertToIngredient(IngredientDto ingredientDto);
    NoteDto convertToNoteDto(Note note);
    Note convertToNote(NoteDto noteDto);
}
