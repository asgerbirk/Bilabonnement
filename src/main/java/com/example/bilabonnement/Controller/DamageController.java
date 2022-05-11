package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.CarAgreement;
import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Service.AgreementService;
import com.example.bilabonnement.Service.CarService;
import com.example.bilabonnement.Service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DamageController {
    private final DamageReportService damageReportService;
    private final AgreementService agreementService;
    private final CarService carService;

@Autowired
    public DamageController(DamageReportService damageReportService, AgreementService agreementService, CarService carService) {
    this.damageReportService = damageReportService;
    this.agreementService = agreementService;

    this.carService = carService;
}

    @GetMapping("/damageReport")
    public String damageReport(Model model){
        model.addAttribute("rentedcars",damageReportService.getAllCars());
        model.addAttribute("totalPrice", carService.totalPrice());
    return "damageReport";
    }


    @PostMapping("/damageReportCreated")
    public String registernewcase(Model model, WebRequest data){
    try {
        int agreementID = Integer.parseInt(data.getParameter("agreementID"));
        int userID = Integer.parseInt(data.getParameter("userID"));
        String damage = data.getParameter("damage");
        int price = Integer.parseInt(data.getParameter("price"));
        DamageReport damageReport = new DamageReport(damage,price);
        damageReportService.createDamageReport(damageReport);
        agreementService.update(userID,price);
        CarAgreement temp =  damageReportService.getAgreementFromId(agreementID);
        int carID = temp.getCar().getCarNumber();
        damageReportService.setDamaged(carID, true);
        agreementService.update(userID,price);
    } catch (Exception e){
        e.printStackTrace();
        return "redirect:/damageReport";
    }

        return "redirect:/index";
    }
}
