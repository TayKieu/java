package com.codegym.demo_spring_data_jpa_a11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
    @RequestMapping(value = "/home",method = RequestMethod.GET)
    public String showHome(Model model){
        model.addAttribute("mess", "HelloWorld");
        return "list";
    }
}
