package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Ingredient;
import com.enesoral.recipeapp.dto.IngredientDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientConverterImpl implements IngredientConverter {

    private final ModelMapper modelMapper;

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
}
