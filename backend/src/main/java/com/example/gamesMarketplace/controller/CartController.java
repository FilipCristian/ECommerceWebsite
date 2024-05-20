package com.example.gamesMarketplace.controller;

import com.example.gamesMarketplace.model.Cart;
import com.example.gamesMarketplace.model.CartItem;
import com.example.gamesMarketplace.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("/{userId}")
    public ResponseEntity<Cart> getCart(@PathVariable String userId) {
        return ResponseEntity.ok(cartService.getCartByUserId(userId));
    }

    @PostMapping("/{userId}/add")
    public ResponseEntity<Cart> addItemToCart(@PathVariable String userId, @RequestBody CartItem cartItem) {
        return ResponseEntity.ok(cartService.addToCart(userId, cartItem));
    }

    @PostMapping("/{userId}/remove/{productId}")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable String userId, @PathVariable String productId) {
        return ResponseEntity.ok(cartService.removeFromCart(userId, productId));
    }

    @PostMapping("/{userId}/update/{productId}")
    public ResponseEntity<Cart> updateItemQuantity(@PathVariable String userId, @PathVariable String productId, @RequestParam int quantity) {
        return ResponseEntity.ok(cartService.updateItemQuantity(userId, productId, quantity));
    }
}