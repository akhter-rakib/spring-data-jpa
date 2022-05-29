package com.example.springdatajpa.service;

import com.example.springdatajpa.dao.ProductRepository;
import com.example.springdatajpa.model.Product;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }
}
