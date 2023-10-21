package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Passenger;
import com.example.RESTclientforairportbooking.model.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class UserAPI {

    public static User getUserByName(String name) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/users/getUserByName/"+name);

        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());
        System.out.println(json);

        ObjectMapper objectMapper = new ObjectMapper();
        User user= objectMapper.readValue(json, new TypeReference<User>() {});

        return user;

    }
}
