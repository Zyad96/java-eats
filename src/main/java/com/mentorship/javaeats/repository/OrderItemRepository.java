package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}