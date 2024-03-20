package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}