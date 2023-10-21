package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Flights;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

public class FlightsAPI {


    public static List<Flights> getAllFlightsOfAirport(String airportName) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/"+airportName+"/flights/all-flights");

        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());
        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Flights> flights = objectMapper.readValue(json, new TypeReference<List<Flights>>() {});

        return flights;


    }
}
