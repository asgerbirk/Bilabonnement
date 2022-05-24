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
public class AgreementController {

    private final AgreementService agreementService;
    private final CustomerService customerService;
    private final CarService carService;

    public AgreementController(AgreementService agreementService, CustomerService customerService, CarService carService) {
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
        return "redirect:/index";


    }

}
