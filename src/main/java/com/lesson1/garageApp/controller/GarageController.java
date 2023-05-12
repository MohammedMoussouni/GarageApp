package com.lesson1.garageApp.controller;

import com.lesson1.garageApp.model.Car;
import com.lesson1.garageApp.service.GarageService;

import java.util.List;

//import javax.lang.model.element.Name;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class GarageController{

    @Autowired
    private GarageService garageService;
    
    //Par défaut, @RequestMapping utilise la méthode GET 
    //donc pas la peine de le préciser ici
    //
    //Sinon cela ressemblerait à ça :
    //
    //@RequestMapping(method = RequestMethod.GET, value = "/cars")
    @RequestMapping(method = RequestMethod.GET, value="/")
    public String helloWorld(@RequestParam(value = "name", defaultValue = "World") String name){
        return String.format("Hello %s !", name);
    }
    // to see the result write this following URL : http://localhost:8080/?name=toto

    @RequestMapping(method = RequestMethod.GET, value="/hello/{name}")
    public String hello(@PathVariable String name){
        return String.format("Hello %s!", name);
    }
    // to see the result write this following URL : http://localhost:8080/hello/toto


    @RequestMapping("/cars")
    public List<Car> getCars(){
        return garageService.getCars();
    }

    @RequestMapping("/car/{id}")
    public Car getCar(@PathVariable long id){
        return garageService.getCar(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/car/{id}")
    public void deleteCar(@PathVariable long id){
        garageService.deleteCar(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/cars")
    public void addCars(@RequestBody List<Car> newCars){
        garageService.addCars((List<Car>) newCars);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/cars/{id}")
    public void updateCar(@RequestBody Car car, @PathVariable long id){
        garageService.updateCar(car, id);
    }

}

