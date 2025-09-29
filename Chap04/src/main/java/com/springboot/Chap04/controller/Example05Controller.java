package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class Example05Controller {

    @RequestMapping("/exam05")
    public String requestMethod() {
        return "viewPage05";
    }

    @PostMapping("/exam05")
    @ResponseBody
    public String requestMethod1() {
        return """
                {result : "ok"}
                """;
    }

    @PutMapping("/exam05")
    @ResponseBody
    public String requestMethod2() {
        return """
                {result : "put ok"}
                """;
    }

    @DeleteMapping("/exam05")
    @ResponseBody
    public String requestMethod3() {
        return """
                {result : "delete ok"}
                """;
    }

    @PatchMapping("/exam05")
    @ResponseBody
    public String requestMethod4() {
        return """
                {result : "patch ok"}
                """;
    }

}
