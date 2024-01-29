package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "Classes")
public class Flightclass {
    @Min(1)
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    private String name;

    public Flightclass(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public Flightclass(String name) {
        this.name = name;
    }

    public Flightclass() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
