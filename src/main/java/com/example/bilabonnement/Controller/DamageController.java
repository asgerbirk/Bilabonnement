package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.DamageReport;
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
    private final CarService carService;

@Autowired
    public DamageController(DamageReportService damageReportService, CarService carService) {
        this.damageReportService = damageReportService;

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
        String damage = data.getParameter("damage");
        int price = Integer.parseInt(data.getParameter("price"));
        DamageReport damageReport = new DamageReport(damage,price);
        damageReportService.createDamageReport(damageReport);
        return "redirect:/index";
    }
}
