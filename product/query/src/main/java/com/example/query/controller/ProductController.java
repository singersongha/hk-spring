package com.example.query.controller;

import com.example.query.entity.Product;
import com.example.query.service.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductServiceImpl productService;
    @GetMapping("/api/v1/products")
    public List<Product> getAll() {

        return productService.getProducts();
    }
}
