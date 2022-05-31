package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Objects;


@Controller
public class CarController {
    // Kodet af Asger

    private final CarService carService;
    private final EmployeeService employeeService;

    @Autowired
    public CarController(CarService carService, EmployeeService employeeService) {
        this.carService = carService;
        this.employeeService = employeeService;
    }

    @GetMapping("/rentedCars")
    public String rentedCars(Model model, HttpSession session){
        model.addAttribute("rentedcars", carService.allRentedCars());
        model.addAttribute("price", carService.priceOfAllRentedCars(0));
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.rentedCars);
    }

    @GetMapping("allCars")
    public String allCars(Model model, HttpSession session){
        model.addAttribute("allCars", carService.getAllCars());
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.allCars);
    }

    @GetMapping("createCar")
    public String createCar(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.createCar);
    }

    @PostMapping("carSuccess")
    public String carSuccess(WebRequest data, HttpSession session){
        carService.createNewCar(
                data.getParameter("model"),
                data.getParameter("brand"),
                data.getParameter("color"),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("price"))),
                false,
                false);
    return employeeService.returnSessionPage(session.getAttribute("user"));
    }


}
