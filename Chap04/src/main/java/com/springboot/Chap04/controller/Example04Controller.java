package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class Example04Controller {
@RequestMapping(value = "/exam04")

public String requestMethod() {
    return "viewPage04";

}
}
