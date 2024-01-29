package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Flight;
import com.example.rezerwacjabiletow.models.Parameters;
import com.example.rezerwacjabiletow.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
public class FlightController {
    @Autowired
    @Qualifier("flightRepository")
    private FlightRepository flightRepository;

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }
    public Iterable<Flight> returnAll(){
        return flightRepository.findAll();
    }
    public Flight getRecord(Long id){

        return flightRepository.getById(id);

    }
    public boolean isExistRecord(Long id){
        return flightRepository.existsById(id);
    }
    public void removeFlight(Long id){
        flightRepository.delete(flightRepository.getById(id));
    }
    public ArrayList<Flight> searchAndReturn(Parameters params){
        ArrayList<Flight>allRecords= (ArrayList<Flight>) returnAll();
        ArrayList<Flight> copy=new ArrayList<>(allRecords);
        for (Flight flight:allRecords) {
            for (int i = 0; i < 5; i++) {
                if (!params.getParams().get(i).equals("")) {
                    switch (i) {
                        case 0:
                            if(rejectByParam(flight, "from", params.getParams().get(0))){
                                copy.remove(flight);
                            };
                            break;
                        case 1:
                            if(rejectByParam(flight, "to", params.getParams().get(1))){
                                copy.remove(flight);
                            };
                            break;
                        case 2:
                            if(rejectByParam(flight, "date", params.getParams().get(2))){
                                copy.remove(flight);
                            };
                            break;
                        case 3:
                            if(rejectByParam(flight, "time", params.getParams().get(3))){
                                copy.remove(flight);
                            };
                            break;
                        case 4:
                            if(rejectByParam(flight, "limitLuggage", params.getParams().get(4))){
                                copy.remove(flight);
                            };
                            break;
                    }
                }
            }
        }
        return copy;
    }
    private boolean rejectByParam(Flight fly,String nameParam,String param){
        switch (nameParam){
            case "from":
                if(!fly.getFrom().getName().equals(param)){
                        return true;
                }
                break;
            case "to":
                if(!fly.getTo().getName().equals(param)){
                        return true;
                }
                break;
            case "date":
                if(!fly.getDate().toString().equals(param)){
                    return true;
                }
                break;
            case "time":
                if(!fly.getTime().toString().equals(param)){
                    return true;
                }
                break;
            case "limitLuggage":
                if(!fly.getLuggageLimit().getAverage().toString().equals(param)){
                    return true;
                }
                break;
        }
        return false;
    }
}
