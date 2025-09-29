package com.example.Chap08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example03Controller {
    @GetMapping("/exam03" )
    public String requestMethod() {
        return "viewPage03";
    }
}
