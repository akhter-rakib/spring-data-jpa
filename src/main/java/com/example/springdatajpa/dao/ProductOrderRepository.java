package com.example.springdatajpa.dao;

import com.example.springdatajpa.dto.ProductReport;
import com.example.springdatajpa.model.ProductOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long> {

    @Query("select new com.example.springdatajpa.dto.ProductReport(p.productName, p.originalPrice, p.sellPrice,  pr.totalPrice)" +
            " from ProductOrderDetails pr join pr.product p")
    public List<ProductReport> getDataByJoin();
}
