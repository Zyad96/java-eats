package com.mentorship.javaeats.service.impl;


import com.mentorship.javaeats.dto.CartItemRequest;
import com.mentorship.javaeats.model.Cart;
import com.mentorship.javaeats.model.CartItem;
import com.mentorship.javaeats.repository.CartItemRepository;
import com.mentorship.javaeats.repository.CartRepository;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {


    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartServiceImpl(CartItemRepository cartItemRepository, CartRepository cartRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
    }

    @Override
    public void updateCartItemQuantity(int cartId, CartItemRequest cartItemRequest) {
        CartItem existingCartItem = getCart(cartId).getCartItem(cartItemRequest.getId());
        updateItemQuantity(existingCartItem, cartItemRequest);
    }


    private void updateItemQuantity(CartItem existingCartItem, CartItemRequest cartItemRequest) {
        if (existingCartItem != null) {
            existingCartItem.setQuantity(cartItemRequest.getQuantity());
            existingCartItem.setUnitPrice(cartItemRequest.getUnitPrice());
            existingCartItem.setTotalPrice(cartItemRequest.getTotalPrice());
            cartItemRepository.save(existingCartItem);
        } else {
            throw new IllegalArgumentException("Cart Item not found in the Cart");
        }
    }

    private Cart getCart(int cartId) {
        // handle the exception
        return cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
    }

}
