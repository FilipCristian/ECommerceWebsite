package com.example.gamesMarketplace.controller;

import com.example.gamesMarketplace.model.AppUser;
import com.example.gamesMarketplace.model.LoginRequest;
import com.example.gamesMarketplace.model.Product;
import com.example.gamesMarketplace.service.AppUserService;
import com.example.gamesMarketplace.service.AuthenticationService;
import com.example.gamesMarketplace.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class AppUserController {

    private AppUserService appUserService;
    private AuthenticationService authenticationService;

    private ProductService productService;

    @Autowired
    public void setAppUserService(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @Autowired
    public void setAuthenticationService(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public List<AppUser> getAppUsers() {
        return appUserService.getAppUsers();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        return authenticationService.authenticateUser(loginRequest);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product newProduct = productService.saveProduct(product);
        return ResponseEntity.ok(newProduct);
    }
}
