package com.example.rezerwacjabiletow.models;

import jakarta.persistence.*;

@Entity
@Table(name="Places")
public class Place {
    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @Column(name="city")
    private String name;

    public Place(String name) {
        this.name = name;
    }

    public Place() {

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
