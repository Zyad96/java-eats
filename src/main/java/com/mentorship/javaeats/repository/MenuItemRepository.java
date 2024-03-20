package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItem, Integer> {
}