package com.todocodeacademy.Rental.service;

import com.todocodeacademy.Rental.dto.RentalRequestDTO;
import com.todocodeacademy.Rental.dto.RentalResponseDTO;
import com.todocodeacademy.Rental.model.Rental;
import com.todocodeacademy.Rental.repository.RentalRepository;
import org.springframework.stereotype.Service;

@Service
public class RentalService {
    private final RentalRepository rentalRepo;

    public RentalService(RentalRepository rentalRepo) {
        this.rentalRepo = rentalRepo;
    }

    // Crear un nuevo alquiler
    public RentalResponseDTO create(RentalRequestDTO req) {
        Rental rental = new Rental();
        rental.setProductId(req.productId());
        rental.setCustomerName(req.customerName());
        rental.setStartTime(req.startTime());
        rental.setEndTime(req.endTime());
        rental = rentalRepo.save(rental);
        return toResp(rental);
    }

    // Obtener un alquiler por id
    public RentalResponseDTO get(Long id) {
        return rentalRepo.findById(id).map(this::toResp).orElse(null);
    }

    // Marcar un alquiler como devuelto
    public RentalResponseDTO returnRental(Long id) {
        return rentalRepo.findById(id).map(rental -> {
            rental.setStatus(Rental.Status.RETURNED);
            return toResp(rentalRepo.save(rental));
        }).orElse(null);
    }

    // Cancelar un alquiler
    public RentalResponseDTO cancel(Long id) {
        return rentalRepo.findById(id).map(rental -> {
            rental.setStatus(Rental.Status.CANCELLED);
            return toResp(rentalRepo.save(rental));
        }).orElse(null);
    }

    // Método auxiliar para mapear Rental → RentalResponseDTO
    private RentalResponseDTO toResp(Rental rental) {

        return new RentalResponseDTO(rental.getId(),rental.getProductId(),rental.getCustomerName(),rental.getStartTime(),rental.getEndTime(),rental.getStatus().name());
    }
}
