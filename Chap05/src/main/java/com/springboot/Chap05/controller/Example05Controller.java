package com.springboot.Chap05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Example05Controller {

    @GetMapping("/exam05/{id}/{passwd}") //url path -> /exam05/admin/1234
    public String requestMapping1(
            @PathVariable("id") String userId,
            @PathVariable("passwd") String userPw,
            Model model
    ) {
        model.addAttribute("data1", "@MatrixVariable 예제");
        model.addAttribute("data2", "경로 변수 id값: " + userId + "<br>경로 변수 passwd값: " + userPw);
        return "viewPage";
    }
}
