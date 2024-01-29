package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
