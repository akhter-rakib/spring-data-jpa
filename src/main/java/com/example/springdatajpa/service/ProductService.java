package com.example.springdatajpa.service;

import com.example.springdatajpa.repository.ProductOrderRepository;
import com.example.springdatajpa.repository.ProductRepository;
import com.example.springdatajpa.dto.ProductReport;
import com.example.springdatajpa.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductOrderRepository productOrderRepository;

    public ProductService(ProductRepository productRepository, ProductOrderRepository productOrderRepository) {
        this.productRepository = productRepository;
        this.productOrderRepository = productOrderRepository;
    }

    public void addProduct(Product product) {
        productRepository.save(product);
    }

    public List<ProductReport> getDataByJoin() {
        return productOrderRepository.getDataByJoin();
    }
}
