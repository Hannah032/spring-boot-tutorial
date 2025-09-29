package com.springBoot.controller;

import com.springBoot.domain.Member;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("member", new Member());
        return "viewPage03";
    }

    @PostMapping
    public String submit(@Valid @ModelAttribute Member member,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "viewPage03";
        } else {
            return "viewPage03_result";
        }
    }
}
