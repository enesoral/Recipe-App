package com.enesoral.recipeapp.dto;

import com.enesoral.recipeapp.domain.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto extends BaseEntityDto {

    @NotBlank
    @Size(min = 10, max = 255)
    private String description;

    @Min(1)
    @Max(999)
    private Integer prepTime;

    @Min(1)
    @Max(999)
    private Integer cookTime;

    @Min(1)
    @Max(100)
    private Integer servings;
    private String source;

    @URL
    private String url;

    @NotBlank
    private String directions;
    private Byte[] image;
    private Difficulty difficulty;
    private NoteDto note;
    private List<IngredientDto> ingredients = new ArrayList<>();
    private Set<CategoryDto> categories = new HashSet<>();

    public void addIngredient(IngredientDto ingredientDto) {
        this.ingredients.add(ingredientDto);
    }

    public void addCategory(CategoryDto categoryDto) {
        this.categories.add(categoryDto);
    }
}