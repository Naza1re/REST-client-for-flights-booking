package com.example.RESTclientforairportbooking.api;

import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Plane;
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
import java.net.ProtocolException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class PlaneAPI {


    public static List<Plane> getAllPlaneOfAirport(String airport_name) throws IOException {

        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/"+airport_name+"/planes/all-planes");
        HttpResponse response = client.execute(request);

        String json = EntityUtils.toString(response.getEntity());

        ObjectMapper objectMapper = new ObjectMapper();
        List<Plane> planeList = objectMapper.readValue(json, new TypeReference<List<Plane>>() {});

        return planeList;
    }
    public static List<Plane> getAllFreePlaneOfAirport(String airport_name) throws IOException {
        HttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://localhost:8082/"+airport_name+"/planes/free");
        HttpResponse response = client.execute(request);
        String json = EntityUtils.toString(response.getEntity());
        ObjectMapper objectMapper = new ObjectMapper();
        List<Plane> planeList =objectMapper.readValue(json, new TypeReference<List<Plane>>() {});
        return planeList;
    }
    public static void addPlaneToFlight(Long id, Long plane_id,String airport_name) throws IOException {
        String apiUrl = "http://localhost:8082/" + airport_name + "/flights/" + id + "/add-pilot/" + plane_id;
        URL url = new URL(apiUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        int responseCode = connection.getResponseCode();
        System.out.println("Response Code: " + responseCode);
        connection.disconnect();

    }


    public static void createPlaneOfAirport(Plane plane, String airportName) throws IOException {
        System.out.println(plane);
        HttpClient client = HttpClients.createDefault();
        HttpPost request = new HttpPost( "http://localhost:8082/"+airportName+"/planes/add-plane");
        request.setHeader("Content-Type", "application/json");

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonUser = objectMapper.writeValueAsString(plane);
        StringEntity entity = new StringEntity(jsonUser, StandardCharsets.UTF_8);
        request.setEntity(entity);
        HttpResponse response = client.execute(request);
    }
}
