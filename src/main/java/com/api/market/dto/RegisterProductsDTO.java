package com.api.market.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterProductsDTO(

        @NotBlank
        String name,
        @NotBlank
        String description,
        @NotNull
        Double price) {
}
