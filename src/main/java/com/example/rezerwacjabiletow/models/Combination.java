package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Combinations")
public class Combination {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Min(0)
    private Integer first_cls_seats =0;
    @Min(0)
    private Integer economical_seats =0;
    @Min(0)
    private Integer bussines_seats =0;

    public Combination(Long id, Integer first_cls_seats, Integer economical_seats, Integer bussines_seats) {
        Id = id;
        this.first_cls_seats = first_cls_seats;
        this.economical_seats = economical_seats;
        this.bussines_seats = bussines_seats;
    }

    public Combination() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Integer getFirst_cls_seats() {
        return first_cls_seats;
    }

    public void setFirst_cls_seats(Integer first_cls_seats) {
        this.first_cls_seats = first_cls_seats;
    }

    public Integer getEconomical_seats() {
        return economical_seats;
    }

    public void setEconomical_seats(Integer economical_seats) {
        this.economical_seats = economical_seats;
    }

    public Integer getBussines_seats() {
        return bussines_seats;
    }

    public void setBussines_seats(Integer bussines_seats) {
        this.bussines_seats = bussines_seats;
    }
}
