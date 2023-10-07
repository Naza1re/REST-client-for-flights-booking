package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.PassengerAPI;
import com.example.RESTclientforairportbooking.model.Passenger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/{airport_name}/flights/{id}")
public class ReservationController {

    @GetMapping("/passengers")
    public String getBookingPage(@PathVariable String airport_name, @PathVariable long id, Model model) throws IOException {
        List<Passenger> passengerList = PassengerAPI.getAllPassengersOfPlane(id,airport_name);
        model.addAttribute("passengerList",passengerList);
        return "booking";
    }
    @GetMapping("/passengers/{id}")
    public String getReservationSeatPage(@PathVariable String airport_name, @PathVariable long id, Model model) throws IOException {
        List<Passenger> passengerList = PassengerAPI.getAllPassengersOfPlane(id,airport_name);
        model.addAttribute("passengerList",passengerList);
        return "booking";
    }


}
