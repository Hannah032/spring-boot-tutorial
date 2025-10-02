package com.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.domain.Person;

@RestController
@RequestMapping("/exam04")
public class Example04Controller {
    @GetMapping
    public Person submit() {
        Person person = new Person();
        person.setName("HongGilSon");
        person.setAge(20);
        person.setEmail("hong@naver.com");
        System.out.println(person);
        return person;
    }
}
