package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> findAll();
    Category findById(Long id);
    List<Long> getSelectedCategoriesId(Long recipeId);
}
