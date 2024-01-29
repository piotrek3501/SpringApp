package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Adress;
import com.example.rezerwacjabiletow.models.User;
import com.example.rezerwacjabiletow.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

@Controller
public class AdressController {
    @Autowired
    @Qualifier("addressRepository")
    private AddressRepository addressRepository;
    public void saveAdress(Adress adress){
        addressRepository.save(adress);
    }
}
