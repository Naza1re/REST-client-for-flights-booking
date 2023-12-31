package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.FlightsAPI;
import com.example.RESTclientforairportbooking.api.PilotAPI;
import com.example.RESTclientforairportbooking.api.PlaneAPI;
import com.example.RESTclientforairportbooking.model.Flights;
import com.example.RESTclientforairportbooking.model.Pilot;
import com.example.RESTclientforairportbooking.model.Plane;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

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
        FlightsAPI.createFlight(airport_name,flights);
        return "redirect:/airports/all-airports";
    }
    @GetMapping("/{id}/add-plane")
    public String addPlanePage(@PathVariable String airport_name, @PathVariable String id,Model model) throws IOException {
        List<Plane> planeList = PlaneAPI.getAllFreePlaneOfAirport(airport_name);
        model.addAttribute("airport_name",airport_name);
        model.addAttribute("planeList",planeList);
        return "add-plane";
    }
    @GetMapping("/{id}/add-pilot")
    public String addPilotPage(Model model, @PathVariable String airport_name, @PathVariable Long id) throws IOException {
        List<Pilot> pilotList = PilotAPI.getAllFreePilotOfAirport(airport_name);
        model.addAttribute("pilotList",pilotList);
        return "add-pilot";
    }
    @PostMapping("/{id}/add-pilot/{pilot_id}")
    public String addPilotToFlight(@PathVariable String airport_name, @PathVariable Long id, @PathVariable Long pilot_id) throws IOException {
        PilotAPI.addPilotToFlight(id,pilot_id,airport_name);

        return "redirect:/"+airport_name+"/flights/all-flights";
    }
    @PostMapping("/{id}/add-plane/{plane_id}")
    public String addPlaneToFlight(@PathVariable String airport_name, @PathVariable Long id, @PathVariable Long plane_id) throws IOException {
        PilotAPI.addPlaneToFlight(id,plane_id,airport_name);
        return "redirect:/"+airport_name+"/flights/all-flights";
    }







}
