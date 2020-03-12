package com.enesoral.recipeapp.dto;

import com.enesoral.recipeapp.domain.UnitOfMeasure;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class IngredientDto extends BaseEntityDto {

    private Long recipeId;
    private String description;
    private BigDecimal amount;
    private UnitOfMeasure uom;
}
