package com.mentorship.javaeats.service.serviceimpl;



import com.mentorship.javaeats.model.Cart;
import com.mentorship.javaeats.model.CartItem;
import com.mentorship.javaeats.repository.CartItemRepository;
import com.mentorship.javaeats.repository.CartRepository;
import com.mentorship.javaeats.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

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
    public CartItem updateCartItem(int cartId, CartItem cartItem) {

        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));

        CartItem existingCartItem = cart.getCartItem(cartItem.getCart_item_id());

        if (existingCartItem != null) {

            existingCartItem.setQuantity(cartItem.getQuantity());

            return cartItemRepository.save(existingCartItem);
        } else {
            throw new IllegalArgumentException("Cart Item not found in the Cart");
        }
    }



    public Set<CartItem> getCartItems(int cartId) {
        Cart cart = cartRepository.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        return cart.getCartItems();
    }
}
