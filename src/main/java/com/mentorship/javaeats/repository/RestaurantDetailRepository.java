package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Entity.RestaurantDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDetailRepository extends JpaRepository<RestaurantDetail, Long> {
}