package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Enum.AccessLevel;
import com.example.bilabonnement.Enum.Pages;
import com.example.bilabonnement.Service.CustomerService;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
public class CustomerController {
    // Kodet af Simon

    private final CustomerService service;
    private final EmployeeService employeeService;

    @Autowired
    public CustomerController(CustomerService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @GetMapping("/createuser")
    public String createUser(){
        return "createuser";
    }

    @PostMapping("/createsuccess")
    public String createSuccess(WebRequest data){
        try{
        service.createCustomer(
                data.getParameter("firstname"),
                data.getParameter("lastname"),
                data.getParameter("email"),
                data.getParameter("number"),
                data.getParameter("password")
        );
        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/createuser";
        }
        return "redirect:/index";
    }

    @GetMapping("/createemployee")
    public String createEmployee(HttpSession session){
        return employeeService.returnPageIfAuthorized(session.getAttribute("user"), Pages.createemployee);
    }

    @PostMapping("employeesuccess")
    public String employeeSuccess(WebRequest data, HttpSession session) {
        try {
            employeeService.createEmployee(data.getParameter("email"),
                    data.getParameter("password"),
                    AccessLevel.valueOf(data.getParameter("accesslevel")));
        } catch (Exception e){
            return "redirect:/createEmployee";
        }
        return employeeService.returnSessionPage(session.getAttribute("user"));
    }

    @PostMapping("/delete")
    public String delete(WebRequest data, HttpSession session){

        String type = data.getParameter("type");
        int id = Integer.parseInt(Objects.requireNonNull(data.getParameter("id")));
        assert type != null;
        employeeService.whichType(type, id);
        return employeeService.returnSessionPage(session.getAttribute("user"));
    }


}
