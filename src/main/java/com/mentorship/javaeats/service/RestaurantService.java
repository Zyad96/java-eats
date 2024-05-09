package com.mentorship.javaeats.service;

import com.mentorship.javaeats.model.dto.request.RestaurantRegistrationRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface RestaurantService {
    public ResponseEntity<String> registerRestaurant(Long customerId, RestaurantRegistrationRequest request);

    public ResponseEntity<String> toggleRestaurantStatus(Long userId, Long restaurantId);

}
