package com.mentorproject1.repository;

import com.mentorproject1.entity.OrderTracking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface OrderTrackingRepository extends JpaRepository<OrderTracking, Integer>, JpaSpecificationExecutor<OrderTracking> {
}