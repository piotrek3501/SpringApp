package com.example.rezerwacjabiletow.controller;


import com.example.rezerwacjabiletow.models.User;

import com.example.rezerwacjabiletow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    @Autowired
    private final UserRepository repository;
    private PasswordEncoder passwordEncoder;

    public UserController(UserRepository reps){
        this.repository=reps;
        passwordEncoder=new BCryptPasswordEncoder();

    }
    public void saveUser(User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
    public Iterable<User> returnAll(){
        return repository.findAll();
    }
    public User findByUsername(String name){
        return repository.findByUsername(name);
    }


}
