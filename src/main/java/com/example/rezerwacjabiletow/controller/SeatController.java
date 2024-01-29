package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Booking;
import com.example.rezerwacjabiletow.models.Seat;
import com.example.rezerwacjabiletow.repositories.SeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SeatController {
    @Autowired
    @Qualifier("seatRepository")
    private SeatRepository seatRepository;
    public List<Seat>getReservedSeatsFrClass(Long IdFlight){

        List<Seat>all=seatRepository.findAll();
        List<Seat>allInFlight =new ArrayList<>();
        for(Seat s:all){
            if((s.getFlight().getId()==IdFlight) && (s.getFlightclass().getId()==1)){
                allInFlight.add(s);
            }
        }

        return allInFlight;
    }
    public List<Seat>getReservedSeatBusClass(Long IdFlight){
        List<Seat>all=seatRepository.findAll();
        List<Seat>allInFlight =new ArrayList<>();
        for(Seat s:all){
            if((s.getFlight().getId()==IdFlight) && (s.getFlightclass().getId()==2)){
                allInFlight.add(s);
            }
        }

        return allInFlight;
    }
    public List<Seat>getReservedSeatEcoClass(Long IdFlight){
        List<Seat>all=seatRepository.findAll();
        List<Seat>allInFlight =new ArrayList<>();
        for(Seat s:all){
            if((s.getFlight().getId()==IdFlight) && (s.getFlightclass().getId()==3)){
                allInFlight.add(s);
            }
        }

        return allInFlight;
    }
    public void save(Seat seat){
        seatRepository.save(seat);
    }
    public boolean checkSeatInFlight(Long FlightId, Booking book){
        List<Seat> checkList=seatRepository.findAll();
        for(Seat s:checkList){
            switch (book.getBookSeat().getFlightclass().getId().intValue()){
                case 1:
                    if((s.getFirstClsSeatnumber()==book.getBookSeat().getFirstClsSeatnumber()) && (s.getFlight().getId()==FlightId)){
                        return false;
                    }
                    break;
                case 2:
                    if((s.getBusinessClsSeatnumber()==book.getBookSeat().getBusinessClsSeatnumber()) && (s.getFlight().getId()==FlightId)){
                        return false;
                    }
                    break;
                case 3:
                    if((s.getEconomicalClsSeatnumber()==book.getBookSeat().getEconomicalClsSeatnumber()) && (s.getFlight().getId()==FlightId)){
                        return false;
                    }
                    break;
            }

        }
        return true;
    }
}
