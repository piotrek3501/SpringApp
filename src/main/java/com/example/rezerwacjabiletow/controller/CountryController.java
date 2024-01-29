package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Country;
import com.example.rezerwacjabiletow.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CountryController {
    @Autowired
    @Qualifier("countryRepository")
    private CountryRepository countryRepository;
    public void saveCountry(Country country){
        countryRepository.save(country);
    }
}
