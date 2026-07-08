package com.todocodeacademy.Rental.repository;
import com.todocodeacademy.Rental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {

}
