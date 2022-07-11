package com.mcommandes.service;

import com.mcommandes.model.Order;
import com.mcommandes.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }
    public Optional<Order> getOrder(Integer id){
        return orderRepository.findById(id);
    }

    }
