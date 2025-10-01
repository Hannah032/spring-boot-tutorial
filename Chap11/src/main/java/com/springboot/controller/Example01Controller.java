package com.springboot.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class Example01Controller {
    @ResponseStatus(value= HttpStatus.BAD_REQUEST, reason = "요청 실패했습니다.")
    @GetMapping("/exam01")
    public void requestMethod() {
        System.out.println(new IllegalArgumentException("잘못된 요청입니다.").getMessage());
    }
}
