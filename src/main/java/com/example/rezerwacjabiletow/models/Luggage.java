package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name="Luggage")
public class Luggage {
    @Min(0)
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private  Float average;
    public Luggage(Long id,Float average){
        this.Id =id;
        this.average=average;

    }
    public Luggage(){

    }

    public Luggage(Long id) {
        Id = id;
    }

    public Luggage(Float average) {
        this.average = average;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        this.Id = id;
    }

    public Float getAverage() {
        return average;
    }

    public void setAverage(Float average) {
        this.average = average;
    }
}
