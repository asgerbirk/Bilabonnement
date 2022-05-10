package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.CustomerAgreementService;
import com.example.bilabonnement.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@Controller
public class CustomerAgreementController {

    private final CustomerAgreementService customerAgreementService;
    private final CustomerService customerService;
    private final CarService carService;

    public CustomerAgreementController(CustomerAgreementService customerAgreementService, CustomerService customerService, CarService carService) {
        this.customerAgreementService = customerAgreementService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @GetMapping("/registerAgreement")
    public String registerAgreement() {
        return "registerAgreement";
    }


    @PostMapping("/registeredAgreement")
    public String succesfullyRegisteredAgreement(WebRequest data) {
        customerAgreementService.registerNewAgreement(
                customerService.getCustomerFromID(Integer.parseInt((Objects.requireNonNull(data.getParameter("customerID"))))),
                data.getParameter("period"),
                data.getParameter("price"),
                carService.getCarFromCarNumber(Integer.parseInt(Objects.requireNonNull(data.getParameter("carNumber")))),
                data.getParameter("location"));

        return "redirect:/index";


    }

}
