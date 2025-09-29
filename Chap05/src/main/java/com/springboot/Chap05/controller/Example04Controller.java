package com.springboot.Chap05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Example04Controller {
    @GetMapping("/exam04/{id}/{passwd}")
    public String requestMapping1(
            @PathVariable("id") String userId,
            @PathVariable("passwd") String userPw,
            @RequestParam(name = "ref", required = false, defaultValue = "no-ref") String ref,
            Model model) {
        model.addAttribute("data1", "@PathVariable 예제");
        model.addAttribute("data2", "경로 변수 id값: " + userId);
        return "viewPage";
    }
}
