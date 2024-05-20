package com.example.gamesMarketplace.model.dao;

import com.example.gamesMarketplace.model.Product;
import org.springframework.data.repository.ListCrudRepository;

public interface ProductDAO extends ListCrudRepository<Product, Long> {

}
