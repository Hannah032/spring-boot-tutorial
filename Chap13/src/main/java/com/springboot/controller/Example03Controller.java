package com.springboot.controller;

import com.springboot.domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
    @GetMapping
    @ResponseBody
    public Person submit() {
        Person person = new Person();
        person.setName("홍길동");
        person.setAge(25);
        person.setEmail("hong@aaa.com");
        return person;
    }
}
