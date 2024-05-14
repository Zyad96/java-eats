package com.mentorship.javaeats.model.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class RestaurantResponse {
    private String name;
    private String status;
    private RestaurantDetailResponse restaurantDetailResponse;

}
