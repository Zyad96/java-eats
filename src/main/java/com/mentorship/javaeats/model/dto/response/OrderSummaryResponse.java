package com.mentorship.javaeats.model.dto.response;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@RequiredArgsConstructor
@Data
public class OrderSummaryResponse {
    private Set<MenuItemResponse> menuItemResponseSet;
    private BigDecimal totalAmount;
    private Instant orderDate;
    private String orderStatus;


    public OrderSummaryResponse(Set<MenuItemResponse> menuItemResponseSet, BigDecimal total, Instant orderDate, String orderStatus) {
        this.menuItemResponseSet = menuItemResponseSet;
        this.totalAmount = total;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
}
