package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.api.PassengerAPI;
import com.example.RESTclientforairportbooking.api.ReservationAPI;
import com.example.RESTclientforairportbooking.model.Passenger;
import com.example.RESTclientforairportbooking.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/{airport_name}/flights/{id}")
public class ReservationController {

    @GetMapping("/passengers")
    public String getBookingPage(@PathVariable String airport_name, @PathVariable long id, Model model) throws IOException {
        List<Passenger> passengerList = PassengerAPI.getAllPassengersOfPlane(id,airport_name);
        model.addAttribute("passengerList",passengerList);
        model.addAttribute("id",id);
        return "choose_seat";
    }
    @GetMapping("/passengers/{id_seat}")
    public String getReservationSeatPage(@PathVariable String airport_name, @PathVariable long id, Model model, @PathVariable long id_seat) throws IOException {
        Passenger passenger = PassengerAPI.getPassengerById(airport_name,id,id_seat);
        model.addAttribute("passengerList",passenger);;
        return "booking";
    }
    @PostMapping("/passengers/{id_seat}")
    public String makeReservation(@RequestParam  String name ,@PathVariable String airport_name, @PathVariable String id, @PathVariable long id_seat) throws IOException {
        ReservationAPI.makeReservation(id,id_seat,name,airport_name);
        return "main";
    }


}
