package com.example.rezerwacjabiletow.repositories;
import com.example.rezerwacjabiletow.models.Adress;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AddressRepository extends JpaRepository<Adress,Long> {

}
