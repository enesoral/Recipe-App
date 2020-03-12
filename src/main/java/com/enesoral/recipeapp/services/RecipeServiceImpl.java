package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.converters.RecipeConverter;
import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.dto.RecipeDto;
import com.enesoral.recipeapp.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImpl implements RecipeService {

    private final RecipeRepository recipeRepository;
    private final RecipeConverter recipeConverter;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeConverter recipeConverter) {

        this.recipeRepository = recipeRepository;
        this.recipeConverter = recipeConverter;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("getRecipes called!");

        Set<Recipe> recipes = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipe -> recipes.add(recipe));
        return recipes;
    }

    @Override
    public Recipe findById(Long l) {
        log.debug("findById of Recipe called with id: " + l);

        Optional<Recipe> recipeOptional = recipeRepository.findById(l);
        if (!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found!");
        }
        return recipeOptional.get();
    }

    @Override
    public RecipeDto findDtoById(Long l) {
        return recipeConverter.convertToRecipeDto(findById(l));
    }

    @Override
    public RecipeDto saveRecipeDto(RecipeDto recipeDto) {
        if (recipeDto == null) {
            return null;
        }
        Recipe savedRecipe = recipeRepository.save(recipeConverter.convertToRecipe(recipeDto));
        log.debug("recipeDto saved with recipeId: " + savedRecipe.getId());
        return recipeConverter.convertToRecipeDto(savedRecipe);
    }
}