package com.example.gamesMarketplace.model;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String password;
}
