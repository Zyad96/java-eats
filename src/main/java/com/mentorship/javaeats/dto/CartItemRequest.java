package com.mentorship.javaeats.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemRequest {

    private Integer id;
    private Integer cartId;
    private Integer menuItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
    private BigDecimal totalPrice;

}
