package com.example.rezerwacjabiletow.controller;

import com.example.rezerwacjabiletow.models.Role;
import com.example.rezerwacjabiletow.models.User;
import com.example.rezerwacjabiletow.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class RoleController {
    private RoleRepository RoleRepository;

    @Autowired
    public RoleController(RoleRepository roleReps){
        RoleRepository=roleReps;
    }

    public void saveRole(Role role) {
        RoleRepository.save(role);
    }
    public Iterable<Role> returnAll(){
        return RoleRepository.findAll();
    }
    public Role initUser(){
        for(Role userRole:RoleRepository.findAll()){
            if(userRole.getType().toString().equals("ROLE_USER")){
                return userRole;
            }
        }
        return new Role();
    }
}
