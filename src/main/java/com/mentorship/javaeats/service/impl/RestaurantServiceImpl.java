package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.model.Entity.Restaurant;
import com.mentorship.javaeats.model.Entity.RestaurantDetail;
import com.mentorship.javaeats.model.dto.request.RestaurantDetailRequest;
import com.mentorship.javaeats.model.dto.request.RestaurantRegistrationRequest;
import com.mentorship.javaeats.model.dto.request.RestaurantRequest;
import com.mentorship.javaeats.repository.RestaurantDetailRepository;
import com.mentorship.javaeats.repository.RestaurantRepository;
import com.mentorship.javaeats.repository.UserRepository;
import com.mentorship.javaeats.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantDetailRepository restaurantDetailRepository;
    private final UserRepository userRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepository, RestaurantDetailRepository restaurantDetailRepository,
                                 UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantDetailRepository = restaurantDetailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<String> registerRestaurant(Long customerId, RestaurantRegistrationRequest request) {
        try {
            if (checkUserAuthority(customerId)) {
                if (validateRestaurantRequest(request.getRestaurantRequest()) && validateRestaurantDetailRequest(request.getRestaurantDetailRequest())) {
                    createRestaurant(request.getRestaurantRequest(), request.getRestaurantDetailRequest());
                    return ResponseEntity.ok().body("Restaurant registered successfully");
                } else {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid request");
                }
            } else {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("User is not authorized to perform this action");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<String> toggleRestaurantStatus(Long userId, Long restaurantId) {
        try {
            if (checkUserAuthority(userId)) {
                toggleStatus(restaurantId);
                return ResponseEntity.ok().body("Restaurant status toggled successfully");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User is not authorized to perform this action");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public ResponseEntity<List<Restaurant>> viewAllRestaurants() {
       List <Restaurant> restaurantList= restaurantRepository.findAll();
       if(!restaurantList.isEmpty()){
           return ResponseEntity.ok(restaurantList);
       }
       else

           return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

    // check if user is admin
    private boolean checkUserAuthority(Long userId){
        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getRoles()
                .stream()
                .anyMatch(role -> role.getName().equals("Admin"));
    }

    // check if restaurant name and status are not null and if restaurant with this name already exists
    private boolean validateRestaurantRequest(RestaurantRequest restaurantRequest) {
        checkRestaurantNameExists(restaurantRequest.getName());
        return restaurantRequest.getName() != null && restaurantRequest.getStatus() != null;
    }

    // check if restaurant with this name already exists
    private void checkRestaurantNameExists(String name) {
        if (restaurantRepository.findByName(name).isPresent()) {
            throw new RuntimeException("Restaurant with this name already exists");
        }
    }

    // check if restaurant description is not null
    private boolean validateRestaurantDetailRequest(RestaurantDetailRequest restaurantDetailRequest) {
        return restaurantDetailRequest.getDescription() != null;
    }

    // create restaurant and restaurant detail entities
    private void createRestaurant(RestaurantRequest restaurantRequest, RestaurantDetailRequest restaurantDetailRequest) {
        Restaurant restaurant = new Restaurant(restaurantRequest.getName(), restaurantRequest.getStatus());
        restaurantRepository.save(restaurant);
        RestaurantDetail restaurantDetail = new RestaurantDetail(restaurantDetailRequest.getDescription());
        restaurantDetailRepository.save(restaurantDetail);
        restaurant.setRestaurantDetail(restaurantDetail);
        restaurantRepository.save(restaurant);
    }

    // toggle restaurant status
    private void toggleStatus(Long restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setStatus(restaurant.getStatus().equals("Opened") ? "Closed" : "Opened");
        restaurantRepository.save(restaurant);
    }
}
