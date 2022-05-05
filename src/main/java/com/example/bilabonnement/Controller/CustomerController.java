package com.example.bilabonnement.Controller;


import com.example.bilabonnement.Model.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

import static java.lang.Integer.parseInt;

@Controller
public class CustomerController {


    @GetMapping("/createuser")
    public String createUser(WebRequest data){
        String email = data.getParameter("email");
        String password = data.getParameter("password");
        String firstName = data.getParameter("firstname");
        String lastName = data.getParameter("lastname");
        String phoneNumber = data.getParameter("number");
        int number = 0;
        if(phoneNumber != null) {
            number = parseInt(phoneNumber);
        }
        Customer newCustomer = new Customer(firstName,lastName,email, number);


        return "createuser";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
