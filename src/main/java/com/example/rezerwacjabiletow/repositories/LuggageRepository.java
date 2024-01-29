package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Luggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LuggageRepository extends JpaRepository<Luggage,Long> {
}
