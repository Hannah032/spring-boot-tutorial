package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class Example00Controller {

    @GetMapping("/exam00")
    public String requestMethod() {
        return "viewPage00";
    }

//    @PostMapping("/exam00")
//    @PutMapping("/exam00")
//    @DeleteMapping("/exam00")
    @RequestMapping(value = "/exam00", method = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
    @ResponseBody
    public String requestMethod1() {
        return """
                {"result" : "ok"}
                """;
    }
}
