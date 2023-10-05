package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.AirportAPI;
import com.example.RESTclientforairportbooking.model.Airport;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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



}
