package com.example.bilabonnement.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class DamageController {


    @GetMapping("/registernewcase")
    public String registernewcase(WebRequest data){
        String skade = data.getParameter("skade");


        return "registernewcase";
    }


}
