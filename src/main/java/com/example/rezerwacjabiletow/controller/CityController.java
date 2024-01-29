package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.City;
import com.example.rezerwacjabiletow.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class CityController {
    @Autowired
    @Qualifier("cityRepository")
    private CityRepository cityRepository;
    public void saveCity(City city){
        cityRepository.save(city);
    }
}
