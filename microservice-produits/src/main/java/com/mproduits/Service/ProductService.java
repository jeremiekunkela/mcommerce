package com.mproduits.Service;

import com.mproduits.repositories.ProductRepository;
import com.mproduits.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductService {
    @Autowired
private ProductRepository productRepository;
    public List<Product> findAllProduct() {
       return productRepository.findAll();
    }
    public Optional<Product> findProductById(int id) {
        return productRepository.findById(id);
    }
}
