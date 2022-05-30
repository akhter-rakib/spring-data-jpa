package com.example.springdatajpa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductReport {
    private String productName;
    private Double originalPrice;
    private Double sellPrice;
    private Double totalPrice;
}
