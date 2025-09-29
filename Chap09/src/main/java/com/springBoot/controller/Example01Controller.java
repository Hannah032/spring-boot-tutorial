package com.springBoot.controller;

import com.springBoot.domain.Product;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/exam01")
public class Example01Controller {
    @GetMapping
    public String shorForm(Model model) {
        model.addAttribute("product", new Product());
        return "viewPage01";
    }

    @PostMapping
    public String submit(
            @Valid @ModelAttribute Product product,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "viewPage01";
        }
        return "viewPage01_result";
    }
}
