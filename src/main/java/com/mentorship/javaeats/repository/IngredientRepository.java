package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, Integer> {
}