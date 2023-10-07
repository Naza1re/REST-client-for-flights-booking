package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Pilot;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class PilotAPI {
    public static List<Pilot> getAllPilotOfAirport(String airportName) throws IOException {

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/"+airportName+"/pilots/all-pilots");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Pilot> pilots = objectMapper.readValue(json, new TypeReference<List<Pilot>>() {});


        return pilots;

    }
}
