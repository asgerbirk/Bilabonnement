package com.example.bilabonnement.Controller;

import com.example.bilabonnement.Service.CustomerService;
import com.example.bilabonnement.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import java.util.Objects;

@Controller
public class CustomerController {

    private final CustomerService service;
    private final EmployeeService employeeService;

    public CustomerController(CustomerService service, EmployeeService employeeService) {
        this.service = service;
        this.employeeService = employeeService;
    }

    @Autowired


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
    public String createEmployee(){
        return "createemployee";
    }

    @PostMapping("employeesuccess")
    public String employeeSuccess(){



        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/allusers")
    public String allusers(Model model){
        try{
        model.addAttribute("allusers",service.getAllCustomers());

        } catch (Exception e){
            e.printStackTrace();
            return "redirect:/index";
        }
        return "allusers";
    }

    @GetMapping("/masterPage")
    public String masterPage(){
        return "masterPage";
    }

    @PostMapping("/delete")
    public String delete(WebRequest data){

        String type = data.getParameter("type");
        int id = Integer.parseInt(Objects.requireNonNull(data.getParameter("id")));
        assert type != null;
        employeeService.whichType(type, id);
        // Kunne være blæret at lave type som en menu dropdown, således at man kun kan vælge ting der ikke fejler
        return "redirect:/masterPage";
    }


}
