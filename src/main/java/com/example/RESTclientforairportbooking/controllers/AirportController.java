package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.AirportAPI;
import com.example.RESTclientforairportbooking.api.PilotAPI;
import com.example.RESTclientforairportbooking.api.PlaneAPI;
import com.example.RESTclientforairportbooking.model.Airport;
import com.example.RESTclientforairportbooking.model.Pilot;
import com.example.RESTclientforairportbooking.model.Plane;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/airports")
public class AirportController {

    @GetMapping("/all-airports")
    public String getAllAirports(Model model) throws IOException {
        List<Airport> allAirports = AirportAPI.getAllAirports();
        System.out.println(allAirports);
        model.addAttribute("allAirports",allAirports);
        return "main";
    }
    @PostMapping("/add-airport")
    public String addAirport(@ModelAttribute Airport airport) throws IOException {
        AirportAPI.save(airport);
        return "main";
    }
    @GetMapping("/{airport_name}")
    public String getAirport(@PathVariable String airport_name,Model model) throws IOException {
        Airport airport = AirportAPI.getAirport(airport_name);
        model.addAttribute("airport",airport);
        List<Plane> planeList = PlaneAPI.getAllPlaneOfAirport(airport_name);
        model.addAttribute("plane_list",planeList);
        List<Pilot> pilotList = PilotAPI.getAllPilotOfAirport(airport_name);
        model.addAttribute("pilot_list",pilotList);
        return "airport";
    }




}
