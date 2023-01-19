package com.example.java7homeworksdata32.controller;

import com.example.java7homeworksdata32.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/fetch-product")
    public String getProduct(@RequestParam("name") String name) {
        return productService.getProductName(name);
    }

    @GetMapping("/fetch-product-one")
    public List<String> getProduct1(@RequestParam("name") String name) {
        return productService.getProductName1(name);
    }
}