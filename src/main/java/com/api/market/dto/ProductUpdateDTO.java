package com.api.market.dto;

import jakarta.validation.constraints.NotNull;

public record ProductUpdateDTO(

        Integer id,
        String name,
        String description,
        Double price) {
}
