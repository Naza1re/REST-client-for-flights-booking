package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPatch;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class ReservationAPI {

    public static void makeReservation(String id, long idSeat, String name, String airport_name) throws IOException {
        User user  = UserAPI.getUserByName(name);
        HttpClient client = HttpClients.createDefault();
        HttpPatch request = new HttpPatch( "http://localhost:8082/"+airport_name+"/flights/"+id+"/passenger/"+idSeat);

        request.setHeader("Content-Type", "application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(user);
        StringEntity entity = new StringEntity(jsonUser);
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
        //working bad
    }
}
