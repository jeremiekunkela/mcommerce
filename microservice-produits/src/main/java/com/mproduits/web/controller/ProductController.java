package com.mproduits.web.controller;

import com.mproduits.Service.ProductService;
import com.mproduits.configurations.ApplicationProportiesConfiguration;
import com.mproduits.model.Product;
import com.mproduits.web.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private ApplicationProportiesConfiguration applicationProportiesConfiguration;



    // Display all products
    @GetMapping(value = "/Products")
    public List<Product> ProductList(){

        List<Product> products = productService.findAllProduct();

        if(products.isEmpty()) throw new ProductNotFoundException("Aucun produit n'est disponible à la vente");

        List<Product> listeLimitee = products.subList(0, applicationProportiesConfiguration.getLimitDeProduits());

        return listeLimitee;

    }

    //Get product by id
    @GetMapping( value = "/Products/{id}")
    public Optional<Product> getProduct(@PathVariable int id) {

        Optional<Product> product = productService.findProductById(id);

        if(!product.isPresent())  throw new ProductNotFoundException("Le produit correspondant à l'id " + id + " n'existe pas");

        return product;
    }
}

