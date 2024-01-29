package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "BookedSeats")
public class Seat {
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_flight")
    private Flight flight;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Id_class")
    private com.example.rezerwacjabiletow.models.Flightclass Flightclass;


    private Integer FirstClsSeatnumber;

    private Integer BusinessClsSeatnumber;
    private Integer EconomicalClsSeatnumber;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_user")
    private User user;

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    public Seat(Flight flight, com.example.rezerwacjabiletow.models.Flightclass flightclass, Integer firstClsSeatnumber, Integer businessClsSeatnumber, Integer economicalClsSeatnumber, User user, Long id) {
        this.flight = flight;
        Flightclass = flightclass;
        FirstClsSeatnumber = firstClsSeatnumber;
        BusinessClsSeatnumber = businessClsSeatnumber;
        EconomicalClsSeatnumber = economicalClsSeatnumber;
        this.user = user;
        Id = id;
    }

    public Seat() {

    }

    public Seat(com.example.rezerwacjabiletow.models.Flightclass flightclass, Long seatnumber) {
        Flightclass = flightclass;
        switch (flightclass.getId().intValue()){
            case 1:
                FirstClsSeatnumber=seatnumber.intValue();
                break;
            case 2:
                BusinessClsSeatnumber=seatnumber.intValue();
                break;
            case 3:
                EconomicalClsSeatnumber=seatnumber.intValue();
                break;
        }
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public com.example.rezerwacjabiletow.models.Flightclass getFlightclass() {
        return Flightclass;
    }

    public void setFlightclass(com.example.rezerwacjabiletow.models.Flightclass flightclass) {
        Flightclass = flightclass;
    }


    public Integer getFirstClsSeatnumber() {
        return FirstClsSeatnumber;
    }

    public void setFirstClsSeatnumber(Integer firstClsSeatnumber) {
        FirstClsSeatnumber = firstClsSeatnumber;
    }

    public Integer getBusinessClsSeatnumber() {
        return BusinessClsSeatnumber;
    }

    public void setBusinessClsSeatnumber(Integer businessClsSeatnumber) {
        BusinessClsSeatnumber = businessClsSeatnumber;
    }

    public Integer getEconomicalClsSeatnumber() {
        return EconomicalClsSeatnumber;
    }

    public void setEconomicalClsSeatnumber(Integer economicalClsSeatnumber) {
        EconomicalClsSeatnumber = economicalClsSeatnumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
