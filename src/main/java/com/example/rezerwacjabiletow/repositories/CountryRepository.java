package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long> {
}
