package com.example.RESTclientforairportbooking.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Plane {

    private Long id;

    private String name;


    public Plane(String name,Pilot pilot){
        this.name = name;

    }
    private List<Passenger> passengerList;
    @JsonIgnore
    private Airport airport;








    public Plane() {

    }
}
