package com.enesoral.recipeapp.dto;

import com.enesoral.recipeapp.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto extends BaseEntityDto {

    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Difficulty difficulty;
    private NoteDto note;
    private Set<IngredientDto> ingredients = new HashSet<>();
    private Set<CategoryDto> categories = new HashSet<>();
}