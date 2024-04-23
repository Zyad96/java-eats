package com.mentorship.javaeats.dto.request;

import lombok.Data;

@Data
public class RestaurantRegistrationRequest {
    private RestaurantRequest restaurantRequest;
    private RestaurantDetailRequest restaurantDetailRequest;
}
