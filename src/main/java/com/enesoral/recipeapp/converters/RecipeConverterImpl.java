package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.domain.Note;
import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.IngredientDto;
import com.enesoral.recipeapp.dto.NoteDto;
import com.enesoral.recipeapp.dto.RecipeDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class RecipeConverterImpl implements RecipeConverter {

    private final ModelMapper modelMapper;
    private final CategoryConverter categoryConverter;
    private final IngredientConverter ingredientConverter;
    private final NoteConverter noteConverter;

    private void addSkipFieldsForConvertToDto() {
        modelMapper.addMappings(new PropertyMap<Recipe, RecipeDto>() {
            @Override
            protected void configure() {
                skip(destination.getCategories());
                skip(destination.getIngredients());
                skip(destination.getNote());
            }
        });
    }

    private void addSkipFieldsForConvertToDomain() {
        modelMapper.addMappings(new PropertyMap<RecipeDto, Recipe>() {
            @Override
            protected void configure() {
                skip(destination.getCategories());
                skip(destination.getIngredients());
                skip(destination.getNote());
            }
        });
    }

    @Override
    public RecipeDto convertToRecipeDto(Recipe recipe) {
        if (recipe == null) {
            return null;
        }

        addSkipFieldsForConvertToDto();

        RecipeDto recipeDto = modelMapper.map(recipe, RecipeDto.class);

        if (recipe.getNote() != null) {
            recipeDto.setNote(noteConverter.convertToNoteDto(recipe.getNote()));
        }

        if (recipe.getCategories() != null && recipe.getCategories().size() > 0) {
            recipe.getCategories()
                    .forEach(category -> recipeDto.getCategories().add(categoryConverter.convertToCategoryDto(category)));
        }

        if (recipe.getIngredients() != null & recipe.getIngredients().size() > 0) {
            recipe.getIngredients()
                    .forEach(ingredient -> recipeDto.getIngredients().add(ingredientConverter.convertToIngredientDto(ingredient)));
        }
        return recipeDto;
    }

    @Override
    public Recipe convertToRecipe(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }

        addSkipFieldsForConvertToDomain();

        Recipe recipe = modelMapper.map(recipeDto, Recipe.class);

        if (recipeDto.getNote() != null) {
            recipe.setNote(noteConverter.convertToNote(recipeDto.getNote()));
        }

        if (recipeDto.getCategories() != null && recipeDto.getCategories().size() > 0) {
            recipeDto.getCategories()
                    .forEach(categoryDto -> recipe.getCategories().add(categoryConverter.convertToCategory(categoryDto)));
        }

        if (recipeDto.getIngredients() != null & recipeDto.getIngredients().size() > 0) {
            recipeDto.getIngredients()
                    .forEach(ingredientDto -> recipe.getIngredients().add(ingredientConverter.convertToIngredient(ingredientDto)));
        }
        return recipe;
    }
}
