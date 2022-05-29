package com.example.springdatajpa.dao;

import com.example.springdatajpa.model.ProductOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDetailsRepository extends JpaRepository<ProductOrderDetails, Long> {
}
