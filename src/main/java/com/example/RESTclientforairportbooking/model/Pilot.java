package com.example.RESTclientforairportbooking.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter

public class Pilot {

    private Long id;


    private String name;


    private int age;


    private List<Flights> flightsList;


    public Pilot(String name,int age){
        this.name = name;
        this.age = age;
    }
    private Airport airport;


    public Pilot() {

    }
}
