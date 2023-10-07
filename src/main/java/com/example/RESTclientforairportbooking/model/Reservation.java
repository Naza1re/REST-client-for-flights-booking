package com.example.RESTclientforairportbooking.model;




import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.util.List;


@Getter
@Setter

@AllArgsConstructor

public class Reservation {

    private Long id;
    @JsonIgnore

    private Flights flights;

    private List<Passenger> passengers;

    private String seat;



    private User user;

    public Reservation() {

    }
}
