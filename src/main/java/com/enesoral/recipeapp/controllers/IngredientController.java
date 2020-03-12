package com.enesoral.recipeapp.controllers;

import com.enesoral.recipeapp.domain.UnitOfMeasure;
import com.enesoral.recipeapp.dto.IngredientDto;
import com.enesoral.recipeapp.services.IngredientService;
import com.enesoral.recipeapp.services.RecipeService;
import com.enesoral.recipeapp.services.UnitOfMeasureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/ingredient")
public class IngredientController {

    private RecipeService recipeService;
    private IngredientService ingredientService;
    private UnitOfMeasureService unitOfMeasureService;

    public IngredientController(RecipeService recipeService, IngredientService ingredientService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.ingredientService = ingredientService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/{id}/update")
    public String updateIngredient(@PathVariable String id, Model model) {
        model.addAttribute("ingredient", ingredientService.findDtoById(Long.parseLong(id)));
        model.addAttribute("uomList", unitOfMeasureService.findAll());
        return "ingredient/ingredient-form";
    }

    @GetMapping("/{recipeId}/new")
    public String newIngredient(@PathVariable String recipeId, Model model) {
        IngredientDto ingredientDto = new IngredientDto();
        ingredientDto.setRecipeId(Long.parseLong(recipeId));
        ingredientDto.setUom(new UnitOfMeasure());
        model.addAttribute("ingredient", ingredientDto);
        model.addAttribute("uomList", unitOfMeasureService.findAll());
        return "ingredient/ingredient-form";
    }

    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute IngredientDto ingredientDto) {
        IngredientDto savedIngredientDto = ingredientService.saveIngredientDto(ingredientDto);
        return "redirect:/recipe/" + savedIngredientDto.getRecipeId() + "/update";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable String id) {
        IngredientDto deletedIngredientDto = ingredientService.findDtoById(Long.parseLong(id));
        ingredientService.deleteById(Long.parseLong(id));
        System.out.println(deletedIngredientDto.getRecipeId());
        return "redirect:/recipe/" + deletedIngredientDto.getRecipeId() + "/update";
    }
}
