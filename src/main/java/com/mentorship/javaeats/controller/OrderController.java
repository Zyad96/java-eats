package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.model.Entity.CartItem;
import com.mentorship.javaeats.model.dto.response.OrderSummaryResponse;
import com.mentorship.javaeats.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/orders/{customerId}")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("{cartId}/place-order")
    public ResponseEntity<String> placeOrder(@PathVariable Long customerId, @PathVariable Long cartId,
                                           @RequestBody Set<CartItem> cartItems) {
        return orderService.placeOrder(customerId, cartId, cartItems);
    }

    @GetMapping("{orderId}/ordersummary")
    public ResponseEntity<OrderSummaryResponse> viewOrderSummary(@PathVariable Long customerId, @PathVariable Long orderId) {
        return orderService.viewOrderSummary(customerId, orderId);
    }
}
