package com.api.market.dto;

import com.api.market.entities.Product;

public record DetailProductDTO(Integer id, String name, String description, Double Price) {

    public DetailProductDTO(Product product) {
        this(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }
}
