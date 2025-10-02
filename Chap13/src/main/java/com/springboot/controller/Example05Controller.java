package com.springboot.controller;

import com.springboot.domain.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam05")
@Slf4j
public class Example05Controller {
    @GetMapping
    public String showForm(@ModelAttribute Person person) {
        return "viewPage05";
    }

    @PutMapping
    public String submit(@ModelAttribute Person person, Model model) {
        model.addAttribute("data1", "@PutMapping 적용하기");
        model.addAttribute("data2", person);
        log.info("person = " + person);

        return "viewPage05_result";
    }
}
