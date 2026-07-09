package com.todocodeacademy.Rental.dto;
import java.time.LocalDateTime;

public record RentalResponseDTO(
        Long id,
        Long productId,
        String customerName,
        LocalDateTime startTime,
        LocalDateTime endTime,
        String status
) {
   
}
