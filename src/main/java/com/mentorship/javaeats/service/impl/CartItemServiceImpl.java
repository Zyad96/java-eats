package com.mentorship.javaeats.service.impl;

import com.mentorship.javaeats.model.Entity.Cart;
import com.mentorship.javaeats.model.Entity.CartItem;
import com.mentorship.javaeats.model.Entity.MenuItem;
import com.mentorship.javaeats.repository.CartItemRepository;
import com.mentorship.javaeats.repository.MenuItemRepository;
import com.mentorship.javaeats.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Set;

@Service
public class CartItemServiceImpl implements CartItemService {


    private final MenuItemRepository menuItemRepository;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(MenuItemRepository menuItemRepository,
                               CartItemRepository cartItemRepository) {
        this.menuItemRepository=menuItemRepository;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem createCartItem(Long menuItemId) {

        MenuItem menuItem = menuItemRepository.findById(menuItemId).orElseThrow(()->new IllegalArgumentException("MenuItem Not Found"));
        CartItem cartItem=new CartItem(1,menuItem.getPrice(),menuItem);
        cartItemRepository.save(cartItem);
        return cartItem;
    }

    @Override
    public void assignCartItemToCart(Cart cart, Long menuItemId) {
        Set<CartItem> cartItems = cart.getCartItems();
        cartItems.add(createCartItem(menuItemId));
        cart.setCartItems(cartItems);
        cartItemRepository.saveAll(cartItems);

    }
}
