package com.example.rezerwacjabiletow.models;

import com.example.rezerwacjabiletow.models.City;
import com.example.rezerwacjabiletow.models.Country;
import jakarta.persistence.*;


@Entity
@Table(name="Adresses")

public class Adress {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long Id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_country")
    private Country country;
    private String Street;
    private String House_number;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name ="Id_city" )
    private City city;

    public Adress() {
    }

    public Adress(Long id, Country country, String street, String house_number, City city) {
        Id = id;
        this.country = country;
        Street = street;
        House_number = house_number;
        this.city = city;
    }


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getHouse_number() {
        return House_number;
    }

    public void setHouse_number(String house_number) {
        House_number = house_number;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
