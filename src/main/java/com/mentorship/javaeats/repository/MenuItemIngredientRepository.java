package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Integer> {
}