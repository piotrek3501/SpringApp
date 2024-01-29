package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight,Long> {
}
