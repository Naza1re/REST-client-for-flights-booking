package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Flights;
import com.example.RESTclientforairportbooking.model.Pilot;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PilotAPI {

    public static List<Pilot> getAllPilotOfAirport(String airportName) throws IOException {

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/"+airportName+"/pilots/all-pilots");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Pilot> pilots = objectMapper.readValue(json, new TypeReference<List<Pilot>>() {});


        return pilots;

    }

    public static List<Pilot> getAllFreePilotOfAirport(String airportName) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/"+airportName+"/pilots/free");
        HttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Pilot> pilots = objectMapper.readValue(json, new TypeReference<List<Pilot>>() {});
        return pilots;
    }





    public static void addPlaneToFlight(Long id, Long planeId, String airportName) throws IOException {
        String apiUrl = "http://localhost:8082/" + airportName + "/flights/" + id + "/add-plane/" + planeId;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);


        connection.disconnect();


    }

    public static void addPilotToFlight(Long id, Long pilotId, String airportName) throws IOException {

        String apiUrl = "http://localhost:8082/" + airportName + "/flights/" + id + "/add-pilot/" + pilotId;

        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);


        connection.disconnect();

    }

    public static void createPlane(String airportName, Pilot pilot) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost( "http://localhost:8082/"+airportName+"/pilots/add-pilot");
        request.setHeader("Content-Type", "application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(pilot);
        StringEntity entity = new StringEntity(jsonUser, StandardCharsets.UTF_8);
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
    }
}
