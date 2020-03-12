package com.enesoral.recipeapp.repositories;

import com.enesoral.recipeapp.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
}
