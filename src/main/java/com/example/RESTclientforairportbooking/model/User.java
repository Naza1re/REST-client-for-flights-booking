package com.example.RESTclientforairportbooking.model;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor

public class User {

    private Long id;


    private String name;


    private String email;


    private String phone;

    @JsonIgnore

    private List<Reservation> reservations;


    public User(String name, String email, String phone) {
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public User() {

    }
}
