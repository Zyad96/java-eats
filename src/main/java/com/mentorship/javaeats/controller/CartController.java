package com.mentorship.javaeats.controller;


import com.mentorship.javaeats.dto.CartItemRequest;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PutMapping("/{cartId}/items/update-quantity")
    public ResponseEntity<Void> updateItemQuantity(@PathVariable int cartId, @RequestBody CartItemRequest cartItemRequest) {
        cartService.updateCartItemQuantity(cartId, cartItemRequest);
        return ResponseEntity.ok().build();
    }


}
