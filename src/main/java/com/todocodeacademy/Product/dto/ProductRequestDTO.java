package com.todocodeacademy.Product.dto;

import com.todocodeacademy.validation.onCreate;
import com.todocodeacademy.validation.onUpdate;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public record ProductRequestDTO(
        @NotBlank(message = "The name is required")
        @Size(max = 60, message = "The names should be maximum 60 characters long")
        String name,

        @NotBlank(message = "The category is required")
        @Size(max = 60, message = "The size should be maximum 60 characters long")
        String category,

        @PositiveOrZero(message = "The stock should be greater or equal to 0")
        @NotNull(message = "The stock is required")
        int stock,

        @NotNull(message = "The price per hour is required")
        @Positive(message = "The price per hour should be positive")
        BigDecimal pricePerHour,

        @NotNull(groups = onUpdate.class, message = "While updating the active is required")
        @AssertTrue(groups = onCreate.class, message = "While creating the active should be true")
        Boolean active
){
}
