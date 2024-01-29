package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Combination;
import com.example.rezerwacjabiletow.repositories.CombinationRepository;
import org.springframework.stereotype.Controller;

@Controller
public class CombinationController {
    private CombinationRepository combinationRepository;
    public CombinationController(CombinationRepository combinationReps){
        combinationRepository=combinationReps;
    }
    public void saveCombination(Combination combination){
        combinationRepository.save(combination);
    }
}
