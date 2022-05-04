package com.example.bilabonnement.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class CustomerController {


    @GetMapping("/createuser")
    public String createUser(WebRequest data){
        String email = data.getParameter("email");
        String password = data.getParameter("password");


        return "createuser";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
