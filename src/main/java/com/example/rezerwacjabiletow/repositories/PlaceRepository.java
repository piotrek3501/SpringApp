package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepository extends JpaRepository <Place,Long> {
}
