package com.springboot.Chap04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Example02Controller {
    @RequestMapping(value = "/exam02", method = RequestMethod.GET)
    public String requestMethod() {
        return "@RestController 예제입니다";
    }
}
