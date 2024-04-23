package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.dto.request.RestaurantDetailRequest;
import com.mentorship.javaeats.dto.request.RestaurantRegistrationRequest;
import com.mentorship.javaeats.dto.request.RestaurantRequest;
import com.mentorship.javaeats.model.*;
import com.mentorship.javaeats.repository.*;
import com.mentorship.javaeats.service.ResturantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ResturantServiceImpl implements ResturantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantDetailRepository restaurantDetailRepository;
    private final UserRepository userRepository;

    @Autowired
    public ResturantServiceImpl(RestaurantRepository restaurantRepository, RestaurantDetailRepository restaurantDetailRepository,
                                UserRepository userRepository) {
        this.restaurantRepository = restaurantRepository;
        this.restaurantDetailRepository = restaurantDetailRepository;
        this.userRepository = userRepository;
    }

    @Override
    public ResponseEntity<Void> registerRestaurant(Integer customerId, RestaurantRegistrationRequest request) {
        try {
            if (checkUserAuthirity(customerId)) {
                if (validateRestaurantRequest(request.getRestaurantRequest()) && validateRestaurantDetailRequest(request.getRestaurantDetailRequest())) {
                    createRestaurant(request.getRestaurantRequest(), request.getRestaurantDetailRequest());
                    return ResponseEntity.ok().build();
                } else {
                    throw new RuntimeException("Invalid request");
                }
            } else {
                throw new RuntimeException("User is not authorized to perform this action");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ResponseEntity<Void> toggleRestaurantStatus(Integer userId, Integer restaurantId) {
        try {
            if (checkUserAuthirity(userId)) {
                toggleStatus(restaurantId);
                return ResponseEntity.ok().build();
            } else {
                throw new RuntimeException("User is not authorized to perform this action");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    private boolean checkUserAuthirity(Integer userId) {
//        return roleRepository.findById(userRoleRepository.findByUserId(userId).getRoleId())
//                .orElseThrow(() -> new RuntimeException("Role not found")).getName().equals("Admin");
//    }

    private boolean checkUserAuthirity(Integer userId){
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        return user.getRoles().stream().anyMatch(role -> role.getClass().getName().equals("Admin"));
    }

    private boolean validateRestaurantRequest(RestaurantRequest restaurantRequest) {
        return restaurantRequest.getName() != null && restaurantRequest.getStatus() != null;
    }

    private boolean validateRestaurantDetailRequest(RestaurantDetailRequest restaurantDetailRequest) {
        return restaurantDetailRequest.getDescription() != null;
    }

    private void createRestaurant(RestaurantRequest restaurantRequest, RestaurantDetailRequest restaurantDetailRequest) {
        Restaurant restaurant = new Restaurant(restaurantRequest.getName(), restaurantRequest.getStatus());
        restaurantRepository.save(restaurant);
        RestaurantDetail restaurantDetail = new RestaurantDetail(restaurantDetailRequest.getDescription());
        restaurantDetailRepository.save(restaurantDetail);
        restaurant.setRestaurantDetails(restaurantDetail);
    }

    private void toggleStatus(Integer restaurantId) {
        Restaurant restaurant = restaurantRepository.findById(restaurantId)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        restaurant.setStatus(restaurant.getStatus().equals("Active") ? "Inactive" : "Active");
        restaurantRepository.save(restaurant);
    }
}
