package com.todocodeacademy.Product.dto;

import java.math.BigDecimal;

public record ProductResponseDTO(
        Long id,
        String name,
        String category,
        int stock,
        BigDecimal pricePerHour,
        boolean active
) {

}
