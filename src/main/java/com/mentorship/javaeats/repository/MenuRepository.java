package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu, Integer> {
}