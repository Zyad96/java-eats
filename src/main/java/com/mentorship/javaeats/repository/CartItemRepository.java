package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
}