package com.example.gamesMarketplace.model.dao;

import com.example.gamesMarketplace.model.AppUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AppUserDAO extends CrudRepository<AppUser, Long> {

    Optional<AppUser> findByUserNameIgnoreCase(String username);

    Optional<AppUser> findByEmailIgnoreCase(String email); 
}
