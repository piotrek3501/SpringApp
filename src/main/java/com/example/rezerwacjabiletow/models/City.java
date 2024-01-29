package com.example.rezerwacjabiletow.models;


import jakarta.persistence.*;

@Entity
@Table(name="Town")
public class City {

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;

    private String name;

    public City(String name) {
        this.name = name;
    }

    public City(Long id, String name) {
        Id = id;
        this.name = name;
    }

    public City() {
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
