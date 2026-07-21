package com.siuzanna.mapper;

import com.siuzanna.dto.RecipeDTO;
import com.siuzanna.model.Recipe;

public class RecipeMapper {

    public static RecipeDTO toDTO(Recipe recipe) {
        RecipeDTO dto = new RecipeDTO();
        dto.setId(recipe.getId());
        dto.setTitle(recipe.getTitle());
        dto.setCategory(recipe.getCategory());
        dto.setDescription(recipe.getDescription());
        dto.setMainImage(recipe.getMainImage());
        dto.setPrepTime(recipe.getPrepTime());
        dto.setCookTime(recipe.getCookTime());
        dto.setServings(recipe.getServings());
        dto.setIngredients(recipe.getIngredients());
        dto.setInstructions(recipe.getInstructions());
        return dto;
    }

    public static Recipe toEntity(RecipeDTO dto) {
        Recipe recipe = new Recipe();
        recipe.setId(dto.getId());
        recipe.setTitle(dto.getTitle());
        recipe.setCategory(dto.getCategory());
        recipe.setDescription(dto.getDescription());
        recipe.setMainImage(dto.getMainImage());
        recipe.setPrepTime(dto.getPrepTime());
        recipe.setCookTime(dto.getCookTime());
        recipe.setServings(dto.getServings());
        recipe.setIngredients(dto.getIngredients());
        recipe.setInstructions(dto.getInstructions());
        return recipe;
    }
}
