package com.lesson1.garageApp.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.lesson1.garageApp.model.Car;
import com.lesson1.garageApp.model.Color;

@Service
public class GarageService {
    
    static private ArrayList<Car> cars = new ArrayList<>(Arrays.asList(
            new Car(1,"laguna", "renault", 2019, Color.RED),
            new Car(2,"C4", "Citroen", 2015, Color.GREEN),
            new Car(3,"Q8", "Audi", 2019, Color.BLUE),
            new Car(4,"207", "peugeot", 2010, Color.RED),
            new Car(5,"Aventador", "Lamborghini", 2035, Color.YELLOW)

    ));


    public List<Car> getCars() {
        return cars;
    }


    public Car getCar(long id) {
        return cars.stream().filter(car -> car.getId() == id).findFirst().orElse(null);
        
    }


    public void deleteCar(long id) {
        cars.removeIf(car -> car.getId() == id);
    }


   /*  
   Dans le cas où l'on chercherait à ajouter une seule voiture
   
   //public void addCar(Car car) {
            cars.add(car);  
    }
    
    */
    
    public void addCars(List<Car> newCars) {
        cars.addAll(newCars);
    }


    public void updateCar(Car car, long id) {
        cars.forEach(car1 -> {
           if (car1.getId() == id)
            cars.set(cars.indexOf(car1), car);
                    
                        });

    }
}
