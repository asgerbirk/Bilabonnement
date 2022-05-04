package com.example.bilabonnement.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CustomerController {


    @GetMapping("/createuser")
    public String createUser(){
        return "createuser";
    }

    @GetMapping("/login")
    public String login(){
        return "login";
    }



}
