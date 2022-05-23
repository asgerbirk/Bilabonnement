package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Enum.AccessLevel;
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
                System.out.println("lol");
                return "index";
        }

    }

    @GetMapping("/masterPage")
    public String masterPage(){
        return "masterPage";
    }

    @GetMapping("/adminPage")
    public String adminPage(){
        return "adminPage";
    }

    @GetMapping("/employeePage")
    public String employeePage(){
        return "employeePage";
    }

    @GetMapping("/userPage")
    public String userPage(){
        return "userPage";
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
