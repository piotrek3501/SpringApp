package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Flightclass;
import com.example.rezerwacjabiletow.repositories.FlightclassRepository;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class FlightclassController {
    private FlightclassRepository flightclassRepository;
    public FlightclassController(FlightclassRepository flightclassReps){
        flightclassRepository=flightclassReps;
    }
    public void saveFlightClass(Flightclass flightclass){
        flightclassRepository.save(flightclass);
    }
    public List<Flightclass> returnAll(){
        return flightclassRepository.findAll();
    }
    public Flightclass  getOneClass(Long id){
        Flightclass result=null;
        for(Flightclass fc:returnAll()){
            if(fc.getId()==id){
                result=fc;
                break;
            }
        }
        return result;
    }
}
