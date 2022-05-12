package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.AccessLevel;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String index(){
        return "index";
    }

    @PostMapping("/logintest")
    public String logintest(WebRequest data){
        EmployeeService es = new EmployeeService();
        AccessLevel userAccessLevel = es.loginValidator(data.getParameter("email"), data.getParameter("password"));
        switch(userAccessLevel){
            case MASTER:
                return "redirect:/registerAgreement";
            case ADMIN:
                return "redirect:/damageReport";
            case EMPLOYEE:
                return "redirect:/rentedCars";
            case USER:
                return "redirect:/rentedCars";
            default:
                return "index";
        }

        //TODO check accesslevel på current user for at styre controllerne til at kunne bestemme hvor useren kan gå hen og ikke kan gå hen, evt en if employeeaccesslevel equals ved return
    }

    @PostMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }

}
