package com.mentorship.javaeats.model.dto.request;

import lombok.Data;

@Data
public class RestaurantRegistrationRequest {
    private RestaurantRequest restaurantRequest;
    private RestaurantDetailRequest restaurantDetailRequest;
}
