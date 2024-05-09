package com.mentorship.javaeats.model.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Data
public class MenuItemResponse {

    private String name;
    private String description;
    private BigDecimal price;



    public MenuItemResponse(String name, String description, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.price = price;
    }
}
