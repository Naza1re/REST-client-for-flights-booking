package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.FlightsAPI;
import com.example.RESTclientforairportbooking.model.Flights;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/{airport_name}/flights")
public class FlightsController {
    @GetMapping("/all-flights")
    public String getAllFlightsOfAirport(@PathVariable String airport_name, Model model) throws IOException {
        List<Flights> flightsOfAirport = FlightsAPI.getAllFlightsOfAirport(airport_name);
        model.addAttribute("flightsOfAirport",flightsOfAirport);
        model.addAttribute("airport",airport_name);
        return "flights";
    }
    @GetMapping("/add-flight")
    public String addFlightPage(@PathVariable String airport_name,Model model){
        model.addAttribute("airport_name",airport_name);
        return "create-flight";
    }
    @PostMapping("/add-flight")
    public String addFlight(@PathVariable String airport_name,@ModelAttribute Flights flights) throws IOException {
        System.out.println(flights);
        FlightsAPI.createFlight(airport_name,flights);
        return "flights";
    }



}
