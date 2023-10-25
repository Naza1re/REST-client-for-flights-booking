package com.example.RESTclientforairportbooking.model;

import lombok.*;

import java.util.List;


@Setter
@Getter
@RequiredArgsConstructor
@AllArgsConstructor

public class Flights   {

    private Long id;


    private String name;

    private boolean active;


    private String departure_date;


    private String departure_time;


    private String arrival;


    private Airport airport;


    private Pilot pilot;


    @Override
    public String toString() {
        return "Flights{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", active=" + active +
                ", departure_date='" + departure_date + '\'' +
                ", departure_time='" + departure_time + '\'' +
                ", arrival='" + arrival + '\'' +
                ", airport=" + airport +
                ", pilot=" + pilot +
                ", plane=" + plane +
                '}';
    }

    public Flights(String name, String departure_date, String departure_time, String arrival) {
        this.name = name;
        this.departure_date = departure_date;
        this.departure_time = departure_time;
        this.arrival = arrival;
    }


    private Plane plane;












}
