package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderStatusRepository extends JpaRepository<OrderStatus, Long> {
    OrderStatus getOrderStatusByName(String placed);
}