package com.springBoot.Chap10.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example00Controller {
    @GetMapping("/admin/exam00")
    public String adminExam00() {
        return "admin/viewPage00";
    }

    @GetMapping("/manager/exam00")
    public String managerExam00() {
        return "manager/viewPage00";
    }

    @GetMapping("/member/exam00")
    public String memberExam00() {
        return "member/viewPage00";
    }

    @GetMapping("exam00")
    public String exam00() {
        return "viewPage00";
    }

}
