package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class Example01Controller {
    @RequestMapping(value = "/exam01", method = RequestMethod.GET)
    public String requestMethod() {
        return "viewPage01";
    }

    @RequestMapping("/exam01")
    @ResponseBody
    public String requestMethod2() {
        return "@ResponseBody 예제입니다";
    }
}
