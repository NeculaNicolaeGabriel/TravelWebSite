package com.example.Travel_Website_1.contoller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TravelController {


    @GetMapping("/travel")
    public String welcomeSite(Model model){


        return "travel";
    }
}
