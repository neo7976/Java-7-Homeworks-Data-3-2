package com.example.java7homeworksdata32.controller;

import com.example.java7homeworksdata32.entity.Order;
import com.example.java7homeworksdata32.model.ProductOrder;
import com.example.java7homeworksdata32.service.ProductService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/fetch-product")
    public List<String> getProduct(@RequestParam("name") String name) {
        return productService.getProductName(name);
    }

    @PostMapping("/add-product")
    public Order addProduct(@RequestBody @Validated ProductOrder productOrder) {
        return productService.addProduct(productOrder);
    }
}