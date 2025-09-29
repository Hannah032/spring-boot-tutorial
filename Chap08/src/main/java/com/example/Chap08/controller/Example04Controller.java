package com.example.Chap08.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example04Controller {
    @GetMapping("/exam04" )
    public String requestMethod() {
        return "viewPage04";
    }
}
