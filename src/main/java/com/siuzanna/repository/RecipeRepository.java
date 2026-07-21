package com.siuzanna.repository;

import com.siuzanna.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    // Здесь пока пусто, так как все базовые методы (создать, удалить, изменить) уже есть внутри JpaRepository!
}
