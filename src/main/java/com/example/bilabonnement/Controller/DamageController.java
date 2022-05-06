package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.DamageReport;
import com.example.bilabonnement.Model.Employee;
import com.example.bilabonnement.Service.DamageReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DamageController {

    private final DamageReportService damageReportService;

@Autowired
    public DamageController(DamageReportService damageReportService) {
        this.damageReportService = damageReportService;

    }

    @GetMapping("/damageReport")
    public String damageReport(){
    return "damageReport";
    }


    @PostMapping("/damageReportCreated")
    public String registernewcase(WebRequest data){
        String damage = data.getParameter("damage");
        int price = Integer.parseInt(data.getParameter("price"));
        DamageReport damageReport = new DamageReport(damage,price);
        damageReportService.createDamageReport(damageReport);
        return "redirect:/index";
    }
}
