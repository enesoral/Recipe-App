package com.enesoral.recipeapp.services;

import com.enesoral.recipeapp.converters.RecipeConverter;
import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.exceptions.NotFoundException;
import com.enesoral.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {

    RecipeService recipeService;

    @Mock
    RecipeRepository recipeRepository;

    @Mock
    RecipeConverter recipeConverter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServiceImpl(recipeRepository, recipeConverter);
    }

    @Test
    public void getRecipes() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipesData = new HashSet<>();
        recipesData.add(recipe);

        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(1, recipes.size());
        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    public void getRecipeById() {
        final Long ID = 1L;
        Recipe recipe = new Recipe();
        recipe.setId(ID);

        when(recipeRepository.findById(ID)).thenReturn(Optional.of(recipe));

        Recipe recipeReturned = recipeService.findById(ID);
        assertNotNull(recipeReturned);
        verify(recipeRepository, times(1)).findById(ID);
    }

    @Test(expected = NotFoundException.class)
    public void getRecipeByIdTestNotFound() throws Exception {
        Optional<Recipe> recipeOptional = Optional.empty();
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.findById(1L);
    }
}