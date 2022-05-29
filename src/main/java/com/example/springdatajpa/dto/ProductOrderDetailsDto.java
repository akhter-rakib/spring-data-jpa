package com.example.springdatajpa.dto;

import lombok.Data;

@Data
public class ProductOrderDetailsDto {
    private Double unitPrice;
    private Double totalPrice;
    private int numberOfQuantity;
    private ProductDto product;
    private ProductOrderDto productOrder;
}
