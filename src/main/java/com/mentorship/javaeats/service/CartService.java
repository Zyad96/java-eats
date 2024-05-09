package com.mentorship.javaeats.service;


import com.mentorship.javaeats.model.dto.request.CartItemRequest;
import com.mentorship.javaeats.model.dto.response.CartItemResponse;
import org.springframework.http.ResponseEntity;

import java.util.Set;

public interface CartService {

    public ResponseEntity<String> updateCartItemQuantity(Long cartId, CartItemRequest cartItemRequest);

    public String addToCart(Long menuItemId, Long userId);

    public ResponseEntity<Set<CartItemResponse>> viewCartItems(Long customerId);

    public ResponseEntity<String> clearAllCartItems(Long cartId);
}
