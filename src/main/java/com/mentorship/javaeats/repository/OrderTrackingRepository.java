package com.mentorship.javaeats.repository;


import com.mentorship.javaeats.model.Entity.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Long> {
    OrderTracking getOrderTrackingByCurrentLocation(String currentLocation);
}