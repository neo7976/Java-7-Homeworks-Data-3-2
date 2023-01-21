package com.example.java7homeworksdata32.service;

import com.example.java7homeworksdata32.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String getProductName(String name) {
        return productRepository.getProductName(name);
    }
}
