package com.example.RESTclientforairportbooking.model;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter

public class Passenger {

    private Long id;


    private int seat;

    private Plane plane;


    private  Reservation reservation;


    private boolean free;

    public boolean isFree(){
        return this.free;
    }



}
