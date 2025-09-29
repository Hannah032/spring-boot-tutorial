package com.example.Chap08.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Locale;

@Controller
public class ExampleController2 {
    @Autowired
    private MessageSource messageSource;

    @GetMapping("/exam01-2")
    public String requestMethod(Model model) {
        model.addAttribute("data", messageSource.getMessage("Person.form.Enter.message", null, Locale.getDefault()));
        return "viewPage01-2";
    }
}
