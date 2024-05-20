package com.example.gamesMarketplace.repository;

import com.example.gamesMarketplace.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    // You can define custom database queries here if needed
}