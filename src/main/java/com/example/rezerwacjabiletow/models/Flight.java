package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name="Flights")
public class Flight {
    @Min(0)
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;


    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    @FutureOrPresent
    private LocalDate Date;

    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    private LocalTime Time;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_from")
    private Place from;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="id_to")
    private Place to;
    @DateTimeFormat(iso=DateTimeFormat.ISO.TIME)
    private  LocalTime FlightTime;
    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="Id_lugagge")
    private Luggage luggageLimit;
    @Valid
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Id_combination")
    private Combination combination;


    @DateTimeFormat(iso=DateTimeFormat.ISO.DATE)
    private LocalDate Date_adding;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_user")
    private User moderator;
    @Digits(integer = 5,fraction = 2)//maksylanie liczba może mieć 5 liczb i 2 po przecinku
    @DecimalMin(value = "0.00",inclusive = false)
    @DecimalMax(value = "100000",inclusive = false)
    @JoinColumn(name="FirstClassPrice")
    private BigDecimal FirstClassPrice;

    @Digits(integer = 5,fraction = 2)
    @DecimalMin(value = "0.00",inclusive = false)
    @DecimalMax(value = "100000",inclusive = false)
    @JoinColumn(name="BussinesClassPrice")
    private BigDecimal BussinesClassPrice;

    @Digits(integer = 5,fraction = 2)
    @DecimalMin(value = "0.00",inclusive = false)
    @DecimalMax(value = "100000",inclusive = false)
    @JoinColumn(name="EconomicalClassPrice")
    private BigDecimal EconomicalClassPrice;

    public Flight(Long id, LocalDate date, LocalTime time, Place from, Place to, LocalTime flightTime,
                  Luggage luggageLimit, Combination combination, LocalDate date_adding, User moderator,BigDecimal FirstCls
                    ,BigDecimal BussinesCls,BigDecimal EconomicalCls) {
        Id = id;
        Date = date;
        Time = time;
        this.from = from;
        this.to = to;
        FlightTime = flightTime;
        this.luggageLimit = luggageLimit;
        this.combination = combination;
        Date_adding = date_adding;
        this.moderator = moderator;
        this.FirstClassPrice=FirstCls;
        this.BussinesClassPrice=BussinesCls;
        this.EconomicalClassPrice=EconomicalCls;
    }

    public Flight() {

    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public LocalDate getDate() {
        return Date;
    }

    public void setDate(LocalDate date) {
        Date = date;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public Place getFrom() {
        return from;
    }

    public void setFrom(Place from) {
        this.from = from;
    }

    public Place getTo() {
        return to;
    }

    public void setTo(Place to) {
        this.to = to;
    }

    public LocalTime getFlightTime() {
        return FlightTime;
    }

    public void setFlightTime(LocalTime flightTime) {
        FlightTime = flightTime;
    }

    public Luggage getLuggageLimit() {
        return luggageLimit;
    }

    public void setLuggageLimit(Luggage luggageLimit) {
        this.luggageLimit = luggageLimit;
    }

    public Combination getCombination() {
        return combination;
    }

    public void setCombination(Combination combination) {
        this.combination = combination;
    }

    public LocalDate getDate_adding() {
        return Date_adding;
    }

    public void setDate_adding(LocalDate date_adding) {
        Date_adding = date_adding;
    }

    public User getModerator() {
        return moderator;
    }

    public void setModerator(User moderator) {
        this.moderator = moderator;
    }

    public BigDecimal getFirstClassPrice() {
        return FirstClassPrice;
    }

    public void setFirstClassPrice(BigDecimal firstClassPrice) {
        FirstClassPrice = firstClassPrice.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getBussinesClassPrice() {
        return BussinesClassPrice;
    }

    public void setBussinesClassPrice(BigDecimal bussinesClassPrice) {
        BussinesClassPrice = bussinesClassPrice.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }

    public BigDecimal getEconomicalClassPrice() {
        return EconomicalClassPrice;
    }

    public void setEconomicalClassPrice(BigDecimal economicalClassPrice) {
        EconomicalClassPrice = economicalClassPrice.setScale(2,BigDecimal.ROUND_HALF_EVEN);
    }
}
