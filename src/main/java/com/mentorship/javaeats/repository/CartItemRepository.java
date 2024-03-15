package com.mentorproject1.repository;

import com.mentorproject1.entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CartItemRepository extends JpaRepository<CartItem, Integer>, JpaSpecificationExecutor<CartItem> {
}