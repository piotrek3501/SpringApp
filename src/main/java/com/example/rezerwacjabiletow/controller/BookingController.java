package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Booking;
import com.example.rezerwacjabiletow.repositories.BookingRepository;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BookingController {
    private BookingRepository bookingRepository;

    public BookingController(BookingRepository bookingReps){
        this.bookingRepository=bookingReps;
    }
    public void save(Booking book){
        bookingRepository.save(book);
    }
    public List<Booking> returnListBooking(Long idUser){
        List<Booking> result= bookingRepository.findAll();
        List<Booking>copy=new ArrayList<>(result);
        for(Booking book:result){
            if(book.getUser().getId()!=idUser){
                copy.remove(book);
            }
        }
        for(Booking book:result){
            if (book.getFlight().getDate().isBefore(LocalDate.now())) {
                book.setStatus(false);
            } else {
                book.setStatus(true);
            }
        }
        return copy;
    }

}
