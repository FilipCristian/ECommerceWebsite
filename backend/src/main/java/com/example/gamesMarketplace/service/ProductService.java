package com.example.gamesMarketplace.service;

import com.example.gamesMarketplace.model.Product;
import com.example.gamesMarketplace.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product productDetails) {
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        product.setName(productDetails.getName());
        product.setCategory(productDetails.getCategory());
        product.setNewPrice(productDetails.getNewPrice());
        product.setOldPrice(productDetails.getOldPrice());
        product.setAvailable(productDetails.getAvailable());
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public void deleteProduct(Long id) {
        Product product = getProductById(id);
        productRepository.delete(product);
    }
}
