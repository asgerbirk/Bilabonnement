package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/rentedCars")
    public String rentedCars(Model model){
        model.addAttribute("rentedcars", carService.allRentedCars());
        model.addAttribute("price", carService.totalPrice());
        return "rentedCars";
    }
}
