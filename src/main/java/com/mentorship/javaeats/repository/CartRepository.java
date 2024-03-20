package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer> {
}