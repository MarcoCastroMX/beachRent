package com.todocodeacademy.Product.dto;

import java.math.BigDecimal;

public record ProductRequestDTO(
        String name,
        String category,
        int stock,
        BigDecimal pricePerHour,
        boolean active
){
        public ProductRequestDTO {
                active = true;
        }
}
