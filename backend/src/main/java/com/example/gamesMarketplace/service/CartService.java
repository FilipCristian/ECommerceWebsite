package com.example.gamesMarketplace.service;

import com.example.gamesMarketplace.model.Cart;
import com.example.gamesMarketplace.model.CartItem;
import com.example.gamesMarketplace.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartService {
    @Autowired
    private CartRepository cartRepository;

    public Cart getCartByUserId(String userId) {
        return cartRepository.findByUserId(userId);
    }

    public Cart addToCart(String userId, CartItem newItem) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
        }
        cart.getItems().add(newItem);
        return cartRepository.save(cart);
    }

    public Cart removeFromCart(String userId, String productId) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.getItems().removeIf(item -> item.getProductId().equals(productId));
            return cartRepository.save(cart);
        }
        return cart; // or throw an exception if preferred
    }

    public Cart updateItemQuantity(String userId, String productId, int quantity) {
        Cart cart = cartRepository.findByUserId(userId);
        if (cart != null) {
            cart.getItems().stream()
                    .filter(item -> item.getProductId().equals(productId))
                    .findFirst()
                    .ifPresent(item -> item.setQuantity(quantity));
            return cartRepository.save(cart);
        }
        return cart;
    }
}
