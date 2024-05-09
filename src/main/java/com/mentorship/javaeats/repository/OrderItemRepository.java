package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.MenuItem;
import com.mentorship.javaeats.model.Entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    Set<OrderItem> findAllByMenuItem(MenuItem menuItem);
}