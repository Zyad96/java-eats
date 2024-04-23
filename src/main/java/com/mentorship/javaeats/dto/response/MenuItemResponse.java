package com.mentorship.javaeats.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Data
public class MenuItemResponse {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
    private String status;
    private Integer stockQuantity;



    public MenuItemResponse(Integer id, String name, String description, BigDecimal price, String status, Integer stockQuantity) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.status = status;
        this.stockQuantity = stockQuantity;
    }
}
