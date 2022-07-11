package com.mcommandes.web.controller;


import com.mcommandes.repositories.OrderRepository;
import com.mcommandes.model.Order;
import com.mcommandes.service.OrderService;
import com.mcommandes.web.exceptions.CommandeNotFoundException;
import com.mcommandes.web.exceptions.ImpossibleAjouterCommandeException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping (value = "/orders")
    public ResponseEntity<Order> addOrder(@RequestBody Order order){

        Order newOrder = orderService.addOrder(order);

        if(newOrder == null) throw new ImpossibleAjouterCommandeException("Impossible d'ajouter cette order");

        return new ResponseEntity<Order>(order, HttpStatus.CREATED);
    }

    @GetMapping(value = "/orders/{id}")
    public Optional<Order> getOrder(@PathVariable int id){

        Optional<Order> order = orderService.getOrder(id);

        if(!order.isPresent()) throw new CommandeNotFoundException("Cette order n'existe pas");

        return order;
    }
}
