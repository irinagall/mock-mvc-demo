package com.sparta.idg.mockmvctestingdemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class WebController {

    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("/greeting")
    public String getGreeting(@RequestParam(name = "name", required = false, defaultValue = "Sparta")String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }

}
