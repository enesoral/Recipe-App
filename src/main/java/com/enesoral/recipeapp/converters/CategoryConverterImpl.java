package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.dto.CategoryDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryConverterImpl implements CategoryConverter {

    private final ModelMapper modelMapper;

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
}
