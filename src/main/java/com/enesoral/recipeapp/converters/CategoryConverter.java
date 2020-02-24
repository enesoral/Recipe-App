package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.dto.CategoryDto;

public interface CategoryConverter {
    CategoryDto convertToCategoryDto(Category category);
    Category convertToCategory(CategoryDto categoryDto);
}
