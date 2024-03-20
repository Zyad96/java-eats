package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Integer> {
}