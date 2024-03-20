package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.RestaurantDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDetailRepository extends JpaRepository<RestaurantDetail, Integer> {
}