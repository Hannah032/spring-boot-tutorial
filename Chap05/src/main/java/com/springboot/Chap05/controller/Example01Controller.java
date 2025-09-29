package com.springboot.Chap05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Example01Controller {
    @GetMapping("/exam01")
    public String requestMethod(
            @RequestParam(name = "id", defaultValue = "관리자") String userId,
            @RequestParam(value = "passwd", required = false) String userPw,
            Model model
    ) {
        model.addAttribute("data1", "@RequestParam 예제");
        model.addAttribute("data2", "요청 파라미터 id값: " + userId + "<br>요청 파라미터 passwd값 " + userPw);
        return "viewPage";  // 뷰 이름 반환 (viewPage.html)
    }

    @GetMapping("/login/login")
    public String login(
        @RequestParam(name = "endPoint", required = false) String endPoint,
        @RequestParam(name = "acrValues", required = false) String acrValues,
        @RequestParam(name = "tx", required = false) String tx,
        Model model) {
        model.addAttribute("endPoint", endPoint);
        return "login/login";  // 뷰 이름 반환 (viewPage.html)
    }

        @GetMapping("/cm/z/b/0210/openLginPageForAnyId.do")
        public String loginWork (
        @RequestParam(name = "endPoint", required = false) String endPoint,
        Model model
        ) {
        return "";
        }
    }

