package com.springBoot.Chap10.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example05Controller {
    @GetMapping("/exam05")
    public String requestMethod1(Model model) {
        return "viewPage05";
    }
    @GetMapping("/admin")
    public String requestMethod2(Authentication user, Model model) {
        model.addAttribute("data", user.getName());
        return "viewPage05_result";
    }
    @GetMapping("/logout")
    public String logout(Model model) {
        return "viewPage05";
    }
}
