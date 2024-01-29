package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City,Long> {
}
