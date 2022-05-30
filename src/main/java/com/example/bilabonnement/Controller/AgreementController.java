package com.example.bilabonnement.Controller;
import com.example.bilabonnement.Enum.AccessLevel;
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

        String returnString = employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.registerAgreement);
        return returnString;
    }


    @PostMapping("/registeredAgreement")
    public String succesfullyRegisteredAgreement(WebRequest data, HttpSession session) {
        try{
        agreementService.registerNewAgreement(
                customerService.getCustomerFromID(data.getParameter("customerID")),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("period"))),
                Integer.parseInt(Objects.requireNonNull(data.getParameter("price"))),
                carService.getCarFromCarNumber(data.getParameter("carNumber")),
                data.getParameter("location"));
       // agreementService.setRented(data.getParameter("carNumber"),true);
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/registerAgreement";
        }
        switch((AccessLevel) session.getAttribute("user")){
            case MASTER:
                return "redirect:/masterPage";
            case ADMIN:
                return "redirect:/adminPage";
            case EMPLOYEE:
                return "redirect:/employeePage";
            default:
                return "index";
    }





}
}
