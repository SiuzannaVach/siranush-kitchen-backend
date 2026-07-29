package com.siuzanna.repository;

import com.siuzanna.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // RecipeRepository nos da todos los métodos automáticos de JPA para hacer el CRUD de recetas en la base de datos sin escribir SQL
}
