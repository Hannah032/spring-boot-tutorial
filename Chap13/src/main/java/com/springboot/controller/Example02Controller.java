package com.springboot.controller;

import com.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
@RequestMapping("/exam02")
public class Example02Controller {

    @GetMapping
    public String exam02() {
        return "viewPage02";
    }
    @PostMapping
    public String submit(@RequestBody HashMap<String, String> map, Model model) {
        System.out.println(map);  // 요청 파라미터 확인

        return "viewPage02";
    }

    @PostMapping("/json-request")
    @ResponseBody
    public String jsonRequest(@RequestBody Person person, Model model) {
        System.out.println("person = " + person);  // 요청 파라미터 확인
        return "viewPage02";
    }
}
