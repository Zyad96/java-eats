package com.mentorship.javaeats.model.dto.response;


import com.mentorship.javaeats.model.Entity.OrderItem;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@RequiredArgsConstructor
@Data
public class OrderSummaryResponse {
    private Set<OrderItem> orderItems;
    private BigDecimal totalAmount;
    private Instant orderDate;
    private String orderStatus;


    public OrderSummaryResponse(Set<OrderItem> orderItems, BigDecimal total, Instant orderDate, String orderStatus) {
        this.orderItems = orderItems;
        this.totalAmount = total;
        this.orderDate = orderDate;
        this.orderStatus = orderStatus;
    }
}
