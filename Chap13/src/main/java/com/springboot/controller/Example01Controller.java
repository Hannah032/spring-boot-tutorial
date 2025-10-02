package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {

    @GetMapping
    public String exam01() {
        return "viewPage01";
    }
    @PostMapping
    public String submit(@RequestBody String urlParam, Model model) {
        model.addAttribute("data1", "@RequestBody로 정보 받기");
        model.addAttribute("data2", urlParam);
        System.out.println("urlParam = " + urlParam);

        return "viewPage01_result";
    }
}
