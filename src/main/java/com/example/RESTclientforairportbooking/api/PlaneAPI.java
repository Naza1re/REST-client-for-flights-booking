package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Plane;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.List;

public class PlaneAPI {


    public static List<Plane> getAllPlaneOfAirport(String airport_name) throws IOException {

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/"+airport_name+"/planes/all-planes");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Plane> planeList = objectMapper.readValue(json, new TypeReference<List<Plane>>() {});

        return planeList;
    }




}
