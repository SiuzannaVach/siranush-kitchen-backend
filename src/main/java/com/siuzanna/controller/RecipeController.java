package com.siuzanna.controller;

import com.siuzanna.dto.RecipeDTO;
import com.siuzanna.mapper.RecipeMapper;
import com.siuzanna.model.Recipe;
import com.siuzanna.repository.RecipeRepository;
import com.siuzanna.service.FileStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private FileStorageService fileStorageService;

    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll().stream()
                .map(RecipeMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public RecipeDTO getRecipeById(@PathVariable Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));
        return RecipeMapper.toDTO(recipe);
    }

    @PostMapping
    public RecipeDTO createRecipe(@RequestBody RecipeDTO recipeDTO) {
        Recipe recipe = RecipeMapper.toEntity(recipeDTO);
        Recipe saved = recipeRepository.save(recipe);
        return RecipeMapper.toDTO(saved);
    }


    @PutMapping("/{id}")
    public RecipeDTO updateRecipe(@PathVariable Long id, @RequestBody RecipeDTO updatedDTO) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Receta no encontrada"));

        recipe.setTitle(updatedDTO.getTitle());
        recipe.setCategory(updatedDTO.getCategory());
        recipe.setDescription(updatedDTO.getDescription());
        recipe.setPrepTime(updatedDTO.getPrepTime());
        recipe.setCookTime(updatedDTO.getCookTime());
        recipe.setServings(updatedDTO.getServings());
        recipe.setIngredients(updatedDTO.getIngredients());
        recipe.setInstructions(updatedDTO.getInstructions());

        Recipe saved = recipeRepository.save(recipe);
        return RecipeMapper.toDTO(saved);
    }

    @DeleteMapping("/{id}")
    public String deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
        return "Receta eliminada correctamente";
    }
}