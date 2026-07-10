package com.todocodeacademy.Rental.dto;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record RentalRequestDTO(
        @NotNull(message = "The product id is required")
        @Positive(message = "The product id should be positive")
        Long productId,

        @NotBlank(message = "The customer name is required")
        @Size(max = 60, message = "The customer name should be less than 60 characters")
        String customerName,

        @NotNull(message = "The start time is required")
        @PastOrPresent(message = "The start time should be equal of later than now")
        LocalDateTime startTime,

        @NotNull(message = "The end time is required")
        @Future(message = "The end time should be later than now")
        LocalDateTime endTime
) {

}
