package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.User;
import com.example.rezerwacjabiletow.models.UserForBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserForBookRepository extends JpaRepository<UserForBook,Long> {
}
