package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.CartItem;
import com.mentorship.javaeats.model.Entity.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    Optional<CartItem> findByMenuItem(MenuItem menuItem);
}