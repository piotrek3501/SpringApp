package com.example.rezerwacjabiletow.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/*
* Prosta baza danych typu InMemory
* Celem jest zapoznanie studentów ze Stream API języka Java
* */

public class DatabaseDump {
    private static List<Flight> flightList;

    static {

        flightList = new ArrayList<>();
        long id = 0;

        Luggage luggagelimit=new Luggage(0l,5.0f);
        Flight book = null;
        try {
            LocalDateTime currentDate = LocalDateTime.now();
            //book = new Flight(Long.valueOf(flightList.size()+1),currentDate,"Monachium","Warszawa", Float.valueOf(1.5f),luggagelimit ,100,200,100);
            //book=new Flight(0l,LocalDate.now(), LocalTime.of(10,20),new Place("Warsaw"),new Place("Berlin"),LocalTime.of(1,20),luggagelimit,new Combination(0l,100,100,100)
            //,LocalDate.now(),new User());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        book.setLuggageLimit(new Luggage(1l,10.0f));
        flightList.add(book);


    }

    public static List<Flight> getAllBooks(){
        return flightList;
    }

    public static Flight findBookById(Long id){
        var book = flightList.stream().filter(x -> x.getId() == id).findFirst();
        return book.orElse(new Flight());//jeśli nie znaleziono to zwróć new Book()
    }

    public static void deleteBookById(Long id){
        var book = findBookById(id);
        flightList.remove(book);
    }

    public static void saveOrUpdate(Flight book){
        if(book.getId() == -1l){//brak ID - nowa ksiazka
            //wyszukiwanie maksymalnego Id i zwiększanie o 1
            var max = flightList.stream().max(Comparator.comparing(Flight::getId)).stream().map(x->x.getId() + 1).findFirst();
            var newId = max.isPresent() ? max.get() : 1l;//jeśli lista była pusta i brak max to id=1
            book.setId(newId);
            flightList.add(book);
        }else{//edycja

            var bookToUpdate = findBookById(book.getId());
            var idx = flightList.indexOf(bookToUpdate);//wyszukiwanie indeksu, gdzie znajduje się stara książka
            if(idx != -1) {
                flightList.set(idx, book);//podmieniamy książkę
            }
        }
    }

}
