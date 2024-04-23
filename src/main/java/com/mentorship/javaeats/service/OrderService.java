package com.mentorship.javaeats.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.mentorship.javaeats.model.CartItem;

@Service
public interface OrderService {

    public void placeOrder(Integer userId, Integer cartId, Set<CartItem> cartItems);
}
