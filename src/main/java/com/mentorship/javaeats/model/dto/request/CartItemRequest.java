package com.mentorship.javaeats.model.dto.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class CartItemRequest {

    private Long id;
    private Long cartId;
    private Long menuItemId;
    private Integer quantity;
    private BigDecimal unitPrice;
}
