package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {
}
