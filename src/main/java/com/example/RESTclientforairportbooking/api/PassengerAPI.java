package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Flights;
import com.example.RESTclientforairportbooking.model.Passenger;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class PassengerAPI {


    public static List<Passenger> getAllPassengersOfPlane(long id,String airportName) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/"+airportName+"/flights/"+id+"/passengers");

        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());
        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        List<Passenger> passengerList = objectMapper.readValue(json, new TypeReference<List<Passenger>>() {});

        return passengerList;

    }
}
