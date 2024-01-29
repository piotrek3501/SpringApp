package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {


    User findByUsername(String username);
}
