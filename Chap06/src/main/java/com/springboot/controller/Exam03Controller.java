package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import java.util.Arrays;
import java.util.List;

@Controller
public class Exam03Controller {
    @GetMapping("/Exam03")
    public String showForm() {
        return "viewPage03";
    }

    public void setTitle(Model model) {
        model.addAttribute("title", "Exam03");
    }

    @ModelAttribute
    public void setModel(Model model) {
        model.addAttribute("title", "@ModelAttribute");
    }

    @ModelAttribute("color")
    public List<String> populateColor() {
        return Arrays.asList("red", "green", "blue");
    }
}
