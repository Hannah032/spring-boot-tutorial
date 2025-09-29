package com.example.Chap08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example02Controller {
    @GetMapping("/exam02" )
    public String requestMethod() {
        return "viewPage02";
    }
}
