package com.example.RESTclientforairportbooking.controllers;

import com.example.RESTclientforairportbooking.model.Plane;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("airports/{airport_name}/planes")
public class PlaneController {

}
