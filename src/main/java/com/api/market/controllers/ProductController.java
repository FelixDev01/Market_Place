package com.api.market.controllers;

import com.api.market.dto.RegisterProductsDTO;
import com.api.market.entities.Product;
import com.api.market.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @PostMapping
    public ResponseEntity<String> register(@RequestBody @Valid RegisterProductsDTO data) {
        var product = new Product(data);
        productRepository.save(product);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("New Product Created!");
    }

}
