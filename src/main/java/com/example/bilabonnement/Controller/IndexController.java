package com.example.bilabonnement.Controller;


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
        String email = data.getParameter("email");
        String password = data.getParameter("password");
        String login = es.loginValidator(email, password);
        System.out.println(login);
        switch(login){
            case "sales":
                return "redirect:/registerAgreement";
            case "damage":
                return "redirect:/damageReport";
            case "stats":
                return "redirect:/rentedCars";
            default:
                System.out.println(login);
                return "index";

        }
    }

    @PostMapping("/error")
    public String error(){
        return "error";
    }

}
