/*
package com.mentorship.javaeats.controller;

import com.mentorship.javaeats.model.CartItem;
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
    public ResponseEntity<Void> placeOrder(@PathVariable Integer customerId, @PathVariable Integer cartId,
                                           @RequestBody Set<CartItem> cartItems) {
        orderService.placeOrder(customerId, cartId, cartItems);
        return ResponseEntity.ok().build();
    }
}
*/
