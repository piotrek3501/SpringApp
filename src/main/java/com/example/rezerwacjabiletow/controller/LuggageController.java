package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Luggage;
import com.example.rezerwacjabiletow.repositories.LuggageRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class LuggageController {
    private LuggageRepository luggageRepository;
    public LuggageController(LuggageRepository luggageReps){
        luggageRepository=luggageReps;
    }
    public void saveLuggage(Luggage luggage){
        luggageRepository.save(luggage);
    }
    public List<Luggage> returnAll(){
        return luggageRepository.findAll();
    }
    public Luggage findById(Long id){
        return luggageRepository.getById(id);
    }
    public boolean isExistRecord(Long id){
        return luggageRepository.existsById(id);
    }
    public Luggage getRecord(Long id){
        return luggageRepository.getById(id);
    }
}
