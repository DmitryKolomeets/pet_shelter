package com.example.pet_shelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeLeafController {

    @GetMapping("/template")
    public String main (Model model) {
        model.addAttribute("message", "Hello buddy");
        model.addAttribute("tasks", "hello from tasks");
        model.addAttribute("task", "glory to Ukraine");

        return "welcome";
    }
}
