package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.Customer;
import com.example.bilabonnement.Repository.CustomerRepository;
import com.example.bilabonnement.Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

import static java.lang.Integer.parseInt;

@Controller
public class CustomerController {

    private final CustomerService cService;

    @Autowired
    CustomerController(CustomerService cService){
        this.cService = cService;
    }

    @GetMapping("/createuser")
    public String createUser(){
        return "createuser";
    }

    @PostMapping("/createsuccess")
    public String createsuccess(WebRequest data){
        CustomerRepository cRepo = new CustomerRepository();
        String email = data.getParameter("email");
        String password = data.getParameter("password");
        String firstName = data.getParameter("firstname");
        String lastName = data.getParameter("lastname");
        String number = data.getParameter("number");
        Customer newCustomer = new Customer(firstName,lastName,email, number, password);
        cRepo.createEntity(newCustomer);
        return "redirect:/index";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }


    @GetMapping("/allusers")
    public String allusers(Model model){
        model.addAttribute("allusers",cService.getAllCustomers());
        return "allusers";
    }


}
