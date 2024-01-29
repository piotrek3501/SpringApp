package com.example.rezerwacjabiletow.repositories;

import com.example.rezerwacjabiletow.models.Role;
import com.example.rezerwacjabiletow.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class Config {
@Bean
    public User userBean(){
    return new User("Marek",true);
}
@Bean
    public Role roleBean(){
    return new Role(Role.Types.ROLE_ADMIN);
}
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
/*
    @Bean
    public City cityBean(){
       return new City();

    }
    @Bean
    public Country countryBean(){
        return new Country(0l,"USA");
    }
    @Bean
    public Place placeBean(){
        return new Place("Warsaw");
    }
    @Bean
    public Luggage luggageBean(){
        return new Luggage(0l,1.5f);
    }
    @Bean
    public Combination combinationBean(){
        return new Combination(0l,100,100,100);
    }
    @Bean
    public Flightclass flightclassBean(){
        return new Flightclass(0l,"Business");
    }
    @Bean
    public Moderator moderatorBean(){
        return new Moderator(0l,"Piotr","Kowalski","pch","test");
    }
    @Bean
    public Adress adressBean(Country country,City city){
        return new Adress(0l,country,"Washington","44/5",city);
    }
    @Bean User userBean(){

        return new User(0l,"Marek","Mostowiak",adressBean(countryBean(),cityBean()),"MM","MjakM");
    }
    @Bean Flight flightBean(){

        return new Flight(0l, LocalDate.now(),LocalTime.of(10,20),placeBean(),placeBean(),LocalTime.of(1,20,20),luggageBean(),combinationBean()
        ,LocalDate.now(),moderatorBean());
    }
    @Bean
    public Seat seatBean(){
        return new Seat(flightBean(),flightclassBean(),44,userBean(),0l);
    }
    @Bean
    public Booking bookingBean(){
        return new Booking(0l,userBean(),flightBean(),true,seatBean());
    }
*/





}
