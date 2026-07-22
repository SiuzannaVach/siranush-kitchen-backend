package com.siuzanna.mapper;

import com.siuzanna.dto.RecipeDTO;
import com.siuzanna.model.Category;
import com.siuzanna.model.Recipe;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeMapperTest {

    @Test
    void toDTO_deberiaConvertirRecipeCorrectamente() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        recipe.setTitle("Khash");
        recipe.setCategory(Category.FESTIVAS);
        recipe.setDescription("Sopa tradicional armenia");
        recipe.setPrepTime(20);
        recipe.setCookTime(360);
        recipe.setServings(8);
        recipe.setIngredients(List.of("Patas de ternera"));
        recipe.setInstructions(List.of("Cocinar a fuego lento"));

        RecipeDTO dto = RecipeMapper.toDTO(recipe);

        assertEquals(recipe.getId(), dto.getId());
        assertEquals(recipe.getTitle(), dto.getTitle());
        assertEquals(recipe.getCategory(), dto.getCategory());
    }
}