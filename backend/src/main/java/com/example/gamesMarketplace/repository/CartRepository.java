package com.example.gamesMarketplace.repository;

import com.example.gamesMarketplace.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, String> { // String here assumes the ID type of your Cart model is String
    Cart findByUserId(String userId);
}
