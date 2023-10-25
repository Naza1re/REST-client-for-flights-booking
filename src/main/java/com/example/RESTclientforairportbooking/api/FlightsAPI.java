package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Flights;
import com.example.RESTclientforairportbooking.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
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
    public static void createFlight(String airport_name,Flights flights) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost( "http://localhost:8082/"+airport_name+"/flights/add-flight");
        request.setHeader("Content-Type", "application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(flights);
        StringEntity entity = new StringEntity(jsonUser, StandardCharsets.UTF_8);
        request.setEntity(entity);
        HttpResponse response = client.execute(request);

    }



}
