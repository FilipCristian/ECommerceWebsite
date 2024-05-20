package com.example.gamesMarketplace.model.dao;

import com.example.gamesMarketplace.model.AppUser;
import com.example.gamesMarketplace.model.WebOrder;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface WebOrderDAO extends ListCrudRepository<WebOrder, Long> {

    List<WebOrder> findByUser(AppUser user);
}
