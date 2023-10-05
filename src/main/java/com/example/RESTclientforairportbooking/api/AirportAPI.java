package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.util.List;

public class AirportAPI {

    public static List<Airport> getAllAirports() throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8081/airports/all-airports");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Airport> airports = objectMapper.readValue(json, new TypeReference<List<Airport>>() {});

        return airports;
    }


    public static void save(Airport airport) throws IOException {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost("http://airports/add-airport");
        StringEntity input = new StringEntity("product");
        post.setEntity(input);
        HttpResponse response = client.execute(post);
    }
}
