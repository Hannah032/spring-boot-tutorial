package com.springBoot.controller;

import com.springBoot.domain.Member;
import com.springBoot.domain.Person;
import com.springBoot.domain.PersonValidator;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/exam04")
@Validated
public class Example04Controller {
    @Autowired
    private PersonValidator personValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(personValidator);
    }

    @GetMapping
    public String showForm(Model model) {
        model.addAttribute("person", new Person());
        return "viewPage04";
    }

    @PostMapping
    public String submit(@Valid @ModelAttribute Person person,
                         BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "viewPage04";
        } else {
            return "viewPage04_result";
        }
    }
}
