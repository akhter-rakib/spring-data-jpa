package com.example.springdatajpa.repository;

import com.example.springdatajpa.model.ProductOrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductOrderDetailsRepository extends JpaRepository<ProductOrderDetails, Long> {
}
