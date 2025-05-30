package com.api.market.dto;

import com.api.market.entities.Product;

public record ProductListDTO(
        Integer id,
        String name,
        String description,
        Double price) {

    public ProductListDTO (Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
