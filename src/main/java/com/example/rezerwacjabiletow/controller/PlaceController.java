package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Place;
import com.example.rezerwacjabiletow.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PlaceController {


    private PlaceRepository placeRepository;
    @Autowired
    public PlaceController(PlaceRepository placeReps){
        placeRepository=placeReps;
    }

    public void savePlace(Place place) {
        placeRepository.save(place);
    }
}
