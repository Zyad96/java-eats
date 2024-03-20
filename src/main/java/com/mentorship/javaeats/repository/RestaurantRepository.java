package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {
}