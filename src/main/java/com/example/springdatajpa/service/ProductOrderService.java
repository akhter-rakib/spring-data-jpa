package com.example.springdatajpa.service;

import com.example.springdatajpa.repository.ProductOrderDetailsRepository;
import com.example.springdatajpa.repository.ProductOrderRepository;
import com.example.springdatajpa.dto.ProductOrderDto;
import com.example.springdatajpa.model.ProductOrder;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductOrderService {
    private final ProductOrderRepository productOrderRepository;
    private final ProductOrderDetailsRepository productOrderDetailsRepository;
    private final ModelMapper modelMapper;

    public ProductOrderService(ProductOrderRepository productOrderRepository, ProductOrderDetailsRepository productOrderDetailsRepository, ModelMapper modelMapper) {
        this.productOrderRepository = productOrderRepository;
        this.productOrderDetailsRepository = productOrderDetailsRepository;
        this.modelMapper = modelMapper;
    }


    public void addProductOrder(ProductOrder productOrder) {
       // productOrder.getProductOrderDetails().forEach(productOrderDetails -> productOrderDetails.setProductOrder(productOrder));
        productOrderRepository.save(productOrder);
    }

    public void addProductOrderByDto(ProductOrderDto productOrderDto) {
        ProductOrder productOrder = modelMapper.map(productOrderDto, ProductOrder.class);
       // productOrder.getProductOrderDetails().forEach(productOrderDetails -> productOrderDetails.setProductOrder(productOrder));
        productOrderRepository.save(productOrder);
    }
}
