package com.example.springdatajpa.controller;

import com.example.springdatajpa.dto.ProductOrderDto;
import com.example.springdatajpa.model.ProductOrder;
import com.example.springdatajpa.service.ProductOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOrderController {

    private final ProductOrderService productOrderService;

    public ProductOrderController(ProductOrderService productOrderService) {
        this.productOrderService = productOrderService;
    }

    @PostMapping("/add-product-order")
    public ResponseEntity<?> addProductOrder(@RequestBody ProductOrder productOrder) {
        productOrderService.addProductOrder(productOrder);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/add-product-order-by-dto")
    public ResponseEntity<?> addProductOrderByDto(@RequestBody ProductOrderDto productOrderDto) {
        productOrderService.addProductOrderByDto(productOrderDto);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
