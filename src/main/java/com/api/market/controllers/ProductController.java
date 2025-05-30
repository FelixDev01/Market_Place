package com.api.market.controllers;

import com.api.market.dto.ProductListDTO;
import com.api.market.dto.RegisterProductsDTO;
import com.api.market.entities.Product;
import com.api.market.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity <List<ProductListDTO>> list() {
        List<ProductListDTO> products = productRepository
                .findAll()
                .stream()
                .map(ProductListDTO::new)
                .toList();

        return ResponseEntity.ok(products);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductListDTO> findById (@PathVariable Integer id) {
        var product = productRepository.findById(id);
        if (product.isPresent()) {
            var dto = new ProductListDTO(product.get());
            return ResponseEntity.ok(dto);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }

}
