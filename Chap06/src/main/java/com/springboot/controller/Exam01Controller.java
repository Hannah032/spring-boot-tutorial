package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Exam01Controller {
    @GetMapping("/member")
    public String showForm() {
        return "viewPage01";
    }
}
