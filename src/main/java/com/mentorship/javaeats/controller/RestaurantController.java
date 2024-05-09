package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.model.dto.request.RestaurantRegistrationRequest;
import com.mentorship.javaeats.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping("{customerId}/register")
    public ResponseEntity<String> registerRestaurant(@PathVariable Long customerId, @RequestBody RestaurantRegistrationRequest request) {
        return restaurantService.registerRestaurant(customerId, request);
    }

    @PutMapping("{userId}/{restaurantId}/toggle-status")
    public ResponseEntity<String> toggleRestaurantStatus(@PathVariable Long userId, @PathVariable Long restaurantId) {
        return restaurantService.toggleRestaurantStatus(userId, restaurantId);
    }
}
