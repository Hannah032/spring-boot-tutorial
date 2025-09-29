package com.springboot.Chap05.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class Example06Controller {
    @GetMapping("/exam06/{id1}/user/{id2}") // url 경로 -> /exam06/hong;passwd=1234/user/lee;passwd=5678
    public String requestMapping1(
            @PathVariable("id1") String userId1,
            @MatrixVariable(name = "passwd", pathVar = "id1") String userPw1,
            @PathVariable("id2") String userId2,
            @MatrixVariable(name = "passwd", pathVar = "id2") String userPw2,
            Model model
    ) {
        model.addAttribute("data1", "@MatrixVariable 예제");
        model.addAttribute("data2", "경로 변수 id1값: " + userId1 + "<br> 매트릭스변수 passwd값: " + userPw1 +
                "<br>경로 변수 id2값: " + userId2 + "<br> 매트릭스변수 passwd값: " + userPw2);
        return "viewPage";
    }
}
