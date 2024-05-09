package com.mentorship.javaeats.controller;


import com.mentorship.javaeats.model.dto.request.CartItemRequest;
import com.mentorship.javaeats.model.dto.response.CartItemResponse;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/{cartId}/items/update-quantity")
    public ResponseEntity<String> updateItemQuantity(@PathVariable Long cartId, @RequestBody CartItemRequest cartItemRequest) {
        return cartService.updateCartItemQuantity(cartId, cartItemRequest);
    }

    @PostMapping
    public  ResponseEntity<Void> addItemtoCart(@PathVariable Long menuItemId, @PathVariable Long userId){
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{customerId}/cart")
    public ResponseEntity<Set<CartItemResponse>> viewCartItems(@PathVariable Long customerId) {
        return cartService.viewCartItems(customerId);
    }

    @DeleteMapping("/{cartId}/clear")
    public ResponseEntity<String> clearAllCartItems(@PathVariable Long cartId) {
        return cartService.clearAllCartItems(cartId);
    }
}