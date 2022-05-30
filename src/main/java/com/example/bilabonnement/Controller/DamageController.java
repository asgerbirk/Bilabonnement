package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Model.Agreement;
import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Service.AgreementService;
import com.example.bilabonnement.Service.DamageReportService;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class DamageController {
    private final DamageReportService damageReportService;
    private final AgreementService agreementService;
    private final EmployeeService employeeService;


@Autowired
    public DamageController(DamageReportService damageReportService, AgreementService agreementService, EmployeeService employeeService) {
    this.damageReportService = damageReportService;
    this.agreementService = agreementService;

    this.employeeService = employeeService;
}

    @GetMapping("/damageReport")
    public String damageReport(HttpSession session){
        String returnString = employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.damageReport);
        return returnString;
    }


    @PostMapping("/damageReportCreated")
    public String registernewcase(WebRequest data, HttpSession session){
    try {
        int agreementID = Integer.parseInt(Objects.requireNonNull(data.getParameter("agreementID")));
        Agreement tempAgreement = agreementService.getAgreement(agreementID);
        Customer tempCustomer = tempAgreement.getCustomer();
        int userID = tempCustomer.getID();
        String damage = data.getParameter("damage");
        int price = Integer.parseInt(Objects.requireNonNull(data.getParameter("price")));
        damageReportService.createDamageReport(damage, price);
        agreementService.update(userID,price);
        CarAgreement temp =  damageReportService.getAgreementFromId(agreementID);
        int carID = temp.getCar().getCarNumber();
        damageReportService.setDamaged(carID, true);
        agreementService.update(userID,price);
    } catch (Exception e){
        e.printStackTrace();
        return "redirect:/damageReport";
    }
        switch((AccessLevel) session.getAttribute("user")) {
            case MASTER:
                return "redirect:/masterPage";
            case ADMIN:
                return "redirect:/adminPage";
            case EMPLOYEE:
                return "redirect:/employeePage";
            case USER:
                return "redirect:/userPage";
            default:
                return "index";
        }
    }
}
