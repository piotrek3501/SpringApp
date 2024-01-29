package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Flightclass;
import com.example.rezerwacjabiletow.models.Role;
import com.example.rezerwacjabiletow.models.User;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;


import java.util.Arrays;
import java.util.HashSet;

@Configuration
public class RepositoryInitializer {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CombinationRepository combinationRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private FlightRepository flightRepository;
    @Autowired
    private FlightclassRepository flightclassRepository;
    @Autowired
    private LuggageRepository luggageRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private PlaceRepository placeRepository;
    @Autowired
    private SeatRepository seatRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    InitializingBean init(){
        return ()-> {

/*
            flightclassRepository.save(new Flightclass("Pierwsza Klasa"));
            flightclassRepository.save(new Flightclass("Klasa Bussines"));
            flightclassRepository.save(new Flightclass("Klasa Ekonomiczna"));

            Role roleUser = roleRepository.save(new Role(Role.Types.ROLE_USER));
            Role roleAdmin = roleRepository.save(new Role(Role.Types.ROLE_ADMIN));

            User user = new User("user", true);
            user.setRoles(new HashSet<>(Arrays.asList(roleUser)));
            user.setPassword(passwordEncoder.encode("user"));

            User admin = new User("admin", true);
            admin.setRoles(new HashSet<>(Arrays.asList(roleAdmin)));
            admin.setPassword(passwordEncoder.encode("admin"));

            User test = new User("superuser", true);
            test.setRoles(new HashSet<>(Arrays.asList(roleAdmin, roleUser)));
            test.setPassword(passwordEncoder.encode("superuser "));

            userRepository.save(user);
            userRepository.save(admin);
            userRepository.save(test);


*/


        };
    }


}
