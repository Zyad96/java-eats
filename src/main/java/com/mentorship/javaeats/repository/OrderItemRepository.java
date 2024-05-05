package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}