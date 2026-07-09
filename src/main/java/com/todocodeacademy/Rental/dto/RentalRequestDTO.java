package com.todocodeacademy.Rental.dto;
import java.time.LocalDateTime;

public record RentalRequestDTO(
        Long productId,
        String customerName,
        LocalDateTime startTime,
        LocalDateTime endTime
) {

}
