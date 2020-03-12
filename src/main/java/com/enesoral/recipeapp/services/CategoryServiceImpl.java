package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.dto.CategoryDto;
import com.enesoral.recipeapp.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    RecipeService recipeService;

    public CategoryServiceImpl(CategoryRepository categoryRepository, RecipeService recipeService) {
        this.categoryRepository = categoryRepository;
        this.recipeService = recipeService;
    }

    @Override
    public Set<Category> findAll() {
        return StreamSupport.stream(categoryRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @Override
    public Category findById(Long id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Long> getSelectedCategoriesId(Long recipeId) {
        List<Long> selectedCatsId = new ArrayList<>();
        for(CategoryDto categoryDto : recipeService.findDtoById(recipeId).getCategories()) {
            selectedCatsId.add(categoryDto.getId());
        }
        return selectedCatsId;
    }
}
