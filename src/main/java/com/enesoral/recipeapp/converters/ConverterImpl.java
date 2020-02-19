package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.domain.Note;
import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.CategoryDto;
import com.enesoral.recipeapp.dto.IngredientDto;
import com.enesoral.recipeapp.dto.NoteDto;
import com.enesoral.recipeapp.dto.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class ConverterImpl implements Converter {

    private final ModelMapper modelMapper;

    @Override
    public RecipeDto convertToRecipeDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

        if (recipe.getNote() != null) {
            recipeDto.setNote(convertToNoteDto(recipe.getNote()));
        }

        recipeDto.getCategories().clear();
        if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
            recipe.getCategories()
                    .forEach(category -> recipeDto.getCategories().add(convertToCategoryDto(category)));
        }

        recipeDto.getIngredients().clear();
        if (recipe.getIngredients() != null & recipe.getIngredients().size() > 0) {
            recipe.getIngredients()
                    .forEach(ingredient -> recipeDto.getIngredients().add(convertToIngredientDto(ingredient)));
        }
        return recipeDto;
    }

    @Override
    public Recipe convertToRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }

        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);

        if (recipeDto.getNote() != null) {
            recipe.setNote(convertToNote(recipeDto.getNote()));
        }

        recipe.getCategories().clear();
        if (recipeDto.getCategories() != null && recipeDto.getCategories().size() > 0) {
            recipeDto.getCategories()
                    .forEach(categoryDto -> recipe.getCategories().add(convertToCategory(categoryDto)));
        }

        recipe.getIngredients().clear();
        if (recipeDto.getIngredients() != null & recipeDto.getIngredients().size() > 0) {
            recipeDto.getIngredients()
                    .forEach(ingredientDto -> recipe.getIngredients().add(convertToIngredient(ingredientDto)));
        }
        return recipe;
    }

    @Override
    public CategoryDto convertToCategoryDto(Category category) {
        if (category == null) {
            return null;
        }
        return modelMapper.map(category, CategoryDto.class);
    }

    @Override
    public Category convertToCategory(CategoryDto categoryDto) {
        if (categoryDto == null) {
            return null;
        }
        return modelMapper.map(categoryDto, Category.class);
    }

    @Override
    public IngredientDto convertToIngredientDto(Ingredient ingredient) {
        if (ingredient == null) {
            return null;
        }
        return modelMapper.map(ingredient, IngredientDto.class);
    }

    @Override
    public Ingredient convertToIngredient(IngredientDto ingredientDto) {
        if (ingredientDto == null) {
            return null;
        }
        return modelMapper.map(ingredientDto, Ingredient.class);
    }

    @Override
    public NoteDto convertToNoteDto(Note note) {
        if (note == null) {
            return null;
        }
        return modelMapper.map(note, NoteDto.class);
    }

    @Override
    public Note convertToNote(NoteDto noteDto) {
        if (noteDto == null) {
            return null;
        }
        return modelMapper.map(noteDto, Note.class);
    }
}
