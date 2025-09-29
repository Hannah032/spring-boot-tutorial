package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/example03", method = {RequestMethod.GET })
public class Example03Controller {

    @RequestMapping
    public String requestMethod() {
        return "viewPage03";
    }
}
