package com.enesoral.recipeapp.controllers;

import com.enesoral.recipeapp.domain.Recipe;
import com.enesoral.recipeapp.services.RecipeService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class RecipeControllerTest {

    @Mock
    RecipeService recipeService;

    RecipeController recipeController;

    MockMvc mockMvc;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        recipeController = new RecipeController(recipeService);
    }

    @Test
    public void showById() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(recipeController).build();

        final Long ID = 1L;
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeService.findById(ID)).thenReturn(recipe);

        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("recipe/showRecipe"))
                .andExpect(model().attributeExists("recipe"));
    }
}
