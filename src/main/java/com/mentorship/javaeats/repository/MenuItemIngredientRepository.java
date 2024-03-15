package com.mentorproject1.repository;

import com.mentorproject1.entity.MenuItemIngredient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface MenuItemIngredientRepository extends JpaRepository<MenuItemIngredient, Integer>, JpaSpecificationExecutor<MenuItemIngredient> {
}