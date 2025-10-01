package com.springboot.controller;

import com.springboot.exceptions.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example04Controller {
    @GetMapping("/exam04")
    public void requestMethod() {
        throw new UserException("UserException 메세지입니다.");
    }
}
