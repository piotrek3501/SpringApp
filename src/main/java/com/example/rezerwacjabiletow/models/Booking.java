package com.example.rezerwacjabiletow.models;

import com.example.rezerwacjabiletow.models.Flight;
import com.example.rezerwacjabiletow.models.Seat;
import com.example.rezerwacjabiletow.models.User;
import jakarta.persistence.*;
import jakarta.validation.Valid;

import java.util.Set;

@Entity
@Table(name = "Reservations")
public class Booking {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_users")
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_flights")
    private Flight flight;
    private Boolean status;
    @Valid
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_bookedSeat")
    private Seat bookSeat;

    public Booking(Long id, User user, Flight flight, Boolean status, Seat bookSeat) {
        Id = id;
        this.user = user;
        this.flight = flight;
        this.status = status;
        this.bookSeat = bookSeat;
    }

    public Booking() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Seat getBookSeat() {
        return bookSeat;
    }

    public void setBookSeat(Seat bookSeat) {
        this.bookSeat = bookSeat;
    }
}
