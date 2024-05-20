package com.example.gamesMarketplace.service;


import com.example.gamesMarketplace.model.AppUser;
import com.example.gamesMarketplace.model.WebOrder;
import com.example.gamesMarketplace.model.dao.WebOrderDAO;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderService {

    private WebOrderDAO webOrderDAO;

    public OrderService(WebOrderDAO webOrderDAO) {
        this.webOrderDAO = webOrderDAO;
    }


    public List<WebOrder> getOrders(AppUser user) {
        return webOrderDAO.findByUser(user);
    }

}