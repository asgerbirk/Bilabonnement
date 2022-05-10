package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.AgreementService;
import com.example.bilabonnement.Service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@Controller
public class CustomerAgreementController {

    private final AgreementService agreementService;
    private final CustomerService customerService;
    private final CarService carService;

    public CustomerAgreementController(AgreementService agreementService, CustomerService customerService, CarService carService) {
        this.agreementService = agreementService;
        this.customerService = customerService;
        this.carService = carService;
    }

    @GetMapping("/registerAgreement")
    public String registerAgreement() {
        return "registerAgreement";
    }


    @PostMapping("/registeredAgreement")
    public String succesfullyRegisteredAgreement(WebRequest data) {
        agreementService.registerNewAgreement(
                customerService.getCustomerFromID(Integer.parseInt((Objects.requireNonNull(data.getParameter("customerID"))))),
                data.getParameter("period"),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("price"))),
                carService.getCarFromCarNumber(Integer.parseInt(Objects.requireNonNull(data.getParameter("carNumber")))),
                data.getParameter("location"));

        customerAgreementService.setRented(Integer.parseInt(data.getParameter("carNumber")),true);


        return "redirect:/index";


    }

}
