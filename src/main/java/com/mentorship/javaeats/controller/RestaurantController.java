package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.dto.request.RestaurantRegistrationRequest;
import com.mentorship.javaeats.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/restaurants")
public class RestaurantController {

    private final ResturantService resturantService;

    @Autowired
    public RestaurantController(ResturantService resturantService) {
        this.resturantService = resturantService;
    }

    @PostMapping("{customerId}/register")
    public ResponseEntity<Void> registerRestaurant(@PathVariable Integer customerId, @RequestBody RestaurantRegistrationRequest request) {
        return resturantService.registerRestaurant(customerId, request);
    }

    @PutMapping("{userId}/{restaurantId}/toggle-status")
    public ResponseEntity<Void> toggleRestaurantStatus(@PathVariable Integer userId, @PathVariable Integer restaurantId) {
        return resturantService.toggleRestaurantStatus(userId, restaurantId);
    }
}
