package com.mentorship.javaeats.service;

import com.mentorship.javaeats.model.Entity.Cart;
import com.mentorship.javaeats.model.Entity.CartItem;

import java.math.BigDecimal;

public interface CartItemService {

    public CartItem createCartItem(Long menuItemId);
    public void assignCartItemToCart(Cart cart, Long menuItemId);
}
