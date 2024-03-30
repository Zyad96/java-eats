package com.mentorship.javaeats.service;


import com.mentorship.javaeats.dto.CartItemRequest;

public interface CartService {

    public void updateCartItemQuantity(int cartId, CartItemRequest cartItemRequest);

}
