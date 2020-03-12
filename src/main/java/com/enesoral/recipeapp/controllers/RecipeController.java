package com.enesoral.recipeapp.controllers;

import com.enesoral.recipeapp.domain.Category;
import com.enesoral.recipeapp.dto.CategoryDto;
import com.enesoral.recipeapp.dto.RecipeDto;
import com.enesoral.recipeapp.services.CategoryService;
import com.enesoral.recipeapp.services.RecipeService;
import com.enesoral.recipeapp.services.UnitOfMeasureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
@RequestMapping("/recipe")
public class RecipeController {

    RecipeService recipeService;
    CategoryService categoryService;
    UnitOfMeasureService unitOfMeasureService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService, UnitOfMeasureService unitOfMeasureService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
        this.unitOfMeasureService = unitOfMeasureService;
    }

    @GetMapping("/{id}/show")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findById(Long.parseLong(id)));
        return "recipe/show-recipe";
    }

    @GetMapping("/new")
    public String newRecipe(Model model) {
        model.addAttribute("recipe", new RecipeDto());
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("uomList", unitOfMeasureService.findAll());
        return "recipe/new-recipe";
    }

    @GetMapping("/{id}/update")
    public String updateRecipe(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.findDtoById(Long.parseLong(id)));
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("selectedCats", categoryService.getSelectedCategoriesId(Long.parseLong(id)));
        return "recipe/update-recipe";
    }

    @PostMapping("/save")
    public String saveOrUpdate(@ModelAttribute RecipeDto recipeDto,
                               @RequestParam(value = "cats", required = false) int[] cats) {
        if (cats != null) {
            CategoryDto category = null;
            for (int id : cats) {
                Category cat = categoryService.findById((long) id);
                if (cat != null) {
                    category = new CategoryDto();
                    category.setId(((long) id));
                    recipeDto.addCategory(category);
                }
            }
        }
        RecipeDto savedRecipeDto = recipeService.saveRecipeDto(recipeDto);
        return "redirect:/recipe/" + savedRecipeDto.getId() + "/show";
    }
}
