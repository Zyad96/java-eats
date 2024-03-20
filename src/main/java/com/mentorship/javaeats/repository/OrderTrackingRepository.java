package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Integer> {
}