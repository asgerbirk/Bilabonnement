package com.example.bilabonnement.Controller;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.AgreementService;
import com.example.bilabonnement.Service.CustomerService;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class AgreementController {
    // Kodet af Simon

    private final AgreementService agreementService;
    private final CustomerService customerService;
    private final CarService carService;
    private final EmployeeService employeeService;

    public AgreementController(AgreementService agreementService, CustomerService customerService, CarService carService, EmployeeService employeeService) {
        this.agreementService = agreementService;
        this.customerService = customerService;
        this.carService = carService;
        this.employeeService = employeeService;
    }

    @GetMapping("/registerAgreement")
    public String registerAgreement(HttpSession session) {
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.registerAgreement);
    }


    @PostMapping("/registeredAgreement")
    public String succesfullyRegisteredAgreement(WebRequest data, HttpSession session) {
        try{
        agreementService.registerNewAgreement(
                customerService.getCustomerFromID(data.getParameter("customerID")),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("period"))),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("price"))),
                carService.getCarFromCarNumber(Integer.parseInt(data.getParameter("carNumber"))),
                data.getParameter("location"));
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/registerAgreement";
        }
        return employeeService.returnSessionPage(session.getAttribute("user"));





}
}
