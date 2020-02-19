package com.enesoral.recipeapp.converters;

import com.enesoral.recipeapp.domain.*;
import com.enesoral.recipeapp.dto.CategoryDto;
import com.enesoral.recipeapp.dto.IngredientDto;
import com.enesoral.recipeapp.dto.NoteDto;
import com.enesoral.recipeapp.dto.RecipeDto;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class ConverterImplTest {

    public static final Long RECIPE_ID = 1L;
    public static final Integer COOK_TIME = Integer.valueOf("5");
    public static final Integer PREP_TIME = Integer.valueOf("7");
    public static final String DESCRIPTION = "My Recipe";
    public static final String DIRECTIONS = "Directions";
    public static final Difficulty DIFFICULTY = Difficulty.EASY;
    public static final Integer SERVINGS = Integer.valueOf("3");
    public static final String SOURCE = "Source";
    public static final String URL = "Some URL";
    public static final Long CAT_ID_1 = 1L;
    public static final Long CAT_ID_2 = 2L;
    public static final Long INGRED_ID_1 = 3L;
    public static final Long INGRED_ID_2 = 4L;
    public static final Long NOTE_ID = 9L;

    Converter converter;

    @Before
    public void setUp() throws Exception {
        converter = new ConverterImpl(new ModelMapper());
    }

    @Test
    public void testNullObject(){
        assertNull(converter.convertToRecipeDto(null));
    }

    @Test
    public void convertToRecipeDtoTest() {
        Recipe recipe = new Recipe();
        recipe.setId(RECIPE_ID);
        recipe.setCookTime(COOK_TIME);
        recipe.setPrepTime(PREP_TIME);
        recipe.setDescription(DESCRIPTION);
        recipe.setDifficulty(DIFFICULTY);
        recipe.setDirections(DIRECTIONS);
        recipe.setServings(SERVINGS);
        recipe.setSource(SOURCE);
        recipe.setUrl(URL);

        Note note = new Note();
        note.setId(NOTE_ID);

        recipe.setNote(note);

        Category category = new Category();
        category.setId(CAT_ID_1);

        Category category2 = new Category();
        category2.setId(CAT_ID_2);

        recipe.getCategories().add(category);
        recipe.getCategories().add(category2);

        Ingredient ingredient = new Ingredient();
        ingredient.setId(INGRED_ID_1);

        Ingredient ingredient2 = new Ingredient();
        ingredient2.setId(INGRED_ID_2);

        recipe.getIngredients().add(ingredient);
        recipe.getIngredients().add(ingredient2);

        RecipeDto recipeDto = converter.convertToRecipeDto(recipe);

        assertNotNull(recipeDto);
        assertEquals(RECIPE_ID, recipeDto.getId());
        assertEquals(COOK_TIME, recipeDto.getCookTime());
        assertEquals(PREP_TIME, recipeDto.getPrepTime());
        assertEquals(DESCRIPTION, recipeDto.getDescription());
        assertEquals(DIFFICULTY, recipeDto.getDifficulty());
        assertEquals(DIRECTIONS, recipeDto.getDirections());
        assertEquals(SERVINGS, recipeDto.getServings());
        assertEquals(SOURCE, recipeDto.getSource());
        assertEquals(URL, recipeDto.getUrl());
        assertEquals(NOTE_ID, recipeDto.getNote().getId());
        assertEquals(2, recipeDto.getCategories().size());
        assertEquals(2, recipeDto.getIngredients().size());

    }

    @Test
    public void convertToRecipeTest() {
        RecipeDto recipeDto = new RecipeDto();
        recipeDto.setId(RECIPE_ID);
        recipeDto.setCookTime(COOK_TIME);
        recipeDto.setPrepTime(PREP_TIME);
        recipeDto.setDescription(DESCRIPTION);
        recipeDto.setDifficulty(DIFFICULTY);
        recipeDto.setDirections(DIRECTIONS);
        recipeDto.setServings(SERVINGS);
        recipeDto.setSource(SOURCE);
        recipeDto.setUrl(URL);

        NoteDto noteDto = new NoteDto();
        noteDto.setId(NOTE_ID);

        recipeDto.setNote(noteDto);

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setId(CAT_ID_1);

        CategoryDto categoryDto2 = new CategoryDto();
        categoryDto2.setId(CAT_ID_2);

        recipeDto.getCategories().add(categoryDto);
        recipeDto.getCategories().add(categoryDto2);

        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setId(INGRED_ID_1);

        IngredientDto IngredientDto2 = new IngredientDto();
        IngredientDto2.setId(INGRED_ID_2);

        recipeDto.getIngredients().add(ingredientDto);
        recipeDto.getIngredients().add(IngredientDto2);

        Recipe recipe = converter.convertToRecipe(recipeDto);

        assertNotNull(recipe);
        assertEquals(RECIPE_ID, recipe.getId());
        assertEquals(COOK_TIME, recipe.getCookTime());
        assertEquals(PREP_TIME, recipe.getPrepTime());
        assertEquals(DESCRIPTION, recipe.getDescription());
        assertEquals(DIFFICULTY, recipe.getDifficulty());
        assertEquals(DIRECTIONS, recipe.getDirections());
        assertEquals(SERVINGS, recipe.getServings());
        assertEquals(SOURCE, recipe.getSource());
        assertEquals(URL, recipe.getUrl());
        assertEquals(NOTE_ID, recipe.getNote().getId());
        assertEquals(2, recipe.getCategories().size());
        assertEquals(2, recipe.getIngredients().size());
    }
}