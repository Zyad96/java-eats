package com.mentorship.javaeats.service;

import com.mentorship.javaeats.dto.request.RestaurantRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ResturantService {
    public ResponseEntity<Void> registerRestaurant(Integer customerId, RestaurantRegistrationRequest request);

    public ResponseEntity<Void> toggleRestaurantStatus(Integer userId, Integer restaurantId);

}
