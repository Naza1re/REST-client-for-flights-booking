package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.FlightsAPI;
import com.example.RESTclientforairportbooking.model.Flights;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/{airport_name}/flights")
public class FlightsController {
    @GetMapping("/all-flights")
    public String getAllFlightsOfAirport(@PathVariable String airport_name, Model model) throws IOException {
        List<Flights> flightsOfAirport = FlightsAPI.getAllFlightsOfAirport(airport_name);
        model.addAttribute("flightsOfAirport",flightsOfAirport);
        return "flights";
    }
}
