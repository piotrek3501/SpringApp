package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Flight;
import com.example.rezerwacjabiletow.models.User;
import com.example.rezerwacjabiletow.models.UserForBook;
import com.example.rezerwacjabiletow.repositories.RoleRepository;
import com.example.rezerwacjabiletow.repositories.UserForBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

@Controller
public class UserForBookController {
    private UserForBookRepository userForBookRepository;

    @Autowired
    public UserForBookController(UserForBookRepository Reps){
        userForBookRepository=Reps;
    }
    public void saveUsersSet(UserForBook user){
        userForBookRepository.save(user);
    }
    public Set<UserForBook> returnUsersByFlightId(Flight flight){
        Set<UserForBook>users= (Set<UserForBook>) userForBookRepository.findAll();
        Set<UserForBook>usersCopy= users;
        for(UserForBook user:users){
            if(user.getFlight().getId()!=flight.getId()){
                usersCopy.remove(user);
            }
        }
        return usersCopy;
    }
}
