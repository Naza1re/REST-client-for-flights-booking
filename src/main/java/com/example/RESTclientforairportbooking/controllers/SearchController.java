package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.SearchAPI;
import com.example.RESTclientforairportbooking.model.Flights;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.List;

@Controller

public class SearchController {
    @GetMapping("/find-flight")
    public String findFlight(@RequestParam String city, Model model) throws IOException {
        List<Flights> flights =  SearchAPI.getFlightByCity(city);
        System.out.println(flights);
        model.addAttribute("flights",flights);
        return "find-flight";
    }
}
