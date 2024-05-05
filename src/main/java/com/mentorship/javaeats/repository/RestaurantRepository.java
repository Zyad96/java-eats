package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
}