package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class ReservationAPI {
    public static void makeReservation(String id, String idSeat, String name) throws IOException {

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/airports/a");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Airport> airports = objectMapper.readValue(json, new TypeReference<List<Airport>>() {});

        //working bad
    }
}
