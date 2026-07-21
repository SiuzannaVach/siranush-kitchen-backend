package com.siuzanna.dto;

import com.siuzanna.model.Category;
import lombok.Data;
import java.util.List;

@Data
public class RecipeDTO {
    private Long id;
    private String title;
    private Category category;
    private String description;
    private String mainImage;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private List<String> ingredients;
    private List<String> instructions;
}