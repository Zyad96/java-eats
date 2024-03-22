package com.mentorship.javaeats.controller;



import com.mentorship.javaeats.model.CartItem;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    private final CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{cartId}/items")
    public Collection<CartItem> getCartItems(@PathVariable int cartId) {
        return cartService.getCartItems(cartId);
    }

    @PutMapping("/{cartId}/items/update-quantity")
    public CartItem updateItemQuantity(@PathVariable int cartId, @RequestBody CartItem cartItem) {
        return cartService.updateCartItem(cartId, cartItem);
    }



}
