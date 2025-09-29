package com.springboot.Chap04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Example08Controller {

    @GetMapping("/exam08")
    public ModelAndView requestMethod() {
        ModelAndView mav = new ModelAndView();
        mav.addObject("data1", "ModelAndView 예제");
        mav.addObject("data2", "웹 요청 url은 /exam08 입니다.");
        mav.setViewName("viewPage");
        return mav;
    }
}
