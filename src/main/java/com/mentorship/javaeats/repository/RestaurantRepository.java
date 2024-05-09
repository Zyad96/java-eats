package com.mentorship.javaeats.repository;

import com.mentorship.javaeats.model.Entity.Menu;
import com.mentorship.javaeats.model.Entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByMenu(Menu menu);

    Optional<Restaurant> findByName(String name);
}