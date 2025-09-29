package com.springboot.Chap05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Example03Controller {
    @GetMapping("/exam03/{id}")
    public String requestMapping1(@PathVariable("id") String userId, Model model) {
        model.addAttribute("data1", "@PathVariable 예제");
        model.addAttribute("data2", "경로 변수 id값: " + userId);
        return "viewPage";
    }
}
