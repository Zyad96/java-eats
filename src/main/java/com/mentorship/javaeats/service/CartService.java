package com.mentorship.javaeats.service;



import com.mentorship.javaeats.model.CartItem;

import java.util.Set;

public interface CartService {

    public CartItem updateCartItem(int cartId, CartItem cartItem);
    public Set<CartItem> getCartItems(int cartId);
}
