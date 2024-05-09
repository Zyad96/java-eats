package com.mentorship.javaeats.service;

import com.mentorship.javaeats.model.Entity.CartItem;
import com.mentorship.javaeats.model.dto.response.OrderSummaryResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface OrderService {

    public ResponseEntity<String> placeOrder(Long userId, Long cartId, Set<CartItem> cartItems);

    public ResponseEntity<OrderSummaryResponse> viewOrderSummary(Long customerId, Long orderId);
}
