package com.example.RESTclientforairportbooking.model;




import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Airport {

    private Long id;
    @JsonProperty("name")
    private String name;

    private String city;

    private String street;

    private List<Flights> flightsList;

    private List<Plane> planeList;



}
