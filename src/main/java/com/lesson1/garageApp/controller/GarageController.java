package com.lesson1.garageApp.controller;

import com.lesson1.garageApp.model.Car;
import com.lesson1.garageApp.model.Color;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GarageController {
    
    @RequestMapping("/car")
    public Car getCar(){
        return new Car("laguna","Renault",1869, Color.GREEN);
    }
}
