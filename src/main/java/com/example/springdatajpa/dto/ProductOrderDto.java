package com.example.springdatajpa.dto;

import lombok.Data;

import java.util.List;

@Data
public class ProductOrderDto {
    private Double totalAmount;
    private CustomerDto customer;
    private List<ProductOrderDetailsDto> productOrderDetails;
}
