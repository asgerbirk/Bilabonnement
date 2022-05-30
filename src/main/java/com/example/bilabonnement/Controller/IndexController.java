package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;

@Controller
public class IndexController {

    private final EmployeeService employeeService;

    @Autowired
    public IndexController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }


    @GetMapping("/index")
    public String index(HttpSession session){
        if(session.getAttribute("user")!=null){
            session.invalidate();
        }
        return "index";
    }

    @PostMapping("/logintest")
    public String logintest(WebRequest data, HttpSession session){

        AccessLevel userAccessLevel = employeeService.giveAccessLevel(data.getParameter("email"), data.getParameter("password"));
        session.setAttribute("user",userAccessLevel);
        return employeeService.returnSessionPage(session.getAttribute("user"));
    }

    @GetMapping("/masterPage")
    public String masterPage(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.masterPage);
    }

    @GetMapping("/adminPage")
    public String adminPage(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.adminPage);
    }

    @GetMapping("/employeePage")
    public String employeePage(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.employeePage);
    }

    @GetMapping("/userPage")
    public String userPage(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.userPage);
    }

    @PostMapping("/error")
    public String error(){
        return "error";
    }

    @GetMapping("/delete")
    public String delete(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.delete);
    }
}
