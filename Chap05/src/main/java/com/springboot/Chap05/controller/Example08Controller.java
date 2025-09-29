package com.springboot.Chap05.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.MatrixVariable;

@Controller
public class Example08Controller {
    //url 경로 -> /exam08/admin;passwd=1234;name=관리자/user/lee;passwd=5678;name=사용자
    @GetMapping("/exam08/{id1}/user/{id2}")
    public String requestMapping1(
            @MatrixVariable(pathVar = "id1") MultiValueMap<String, String> var1,
            @MatrixVariable(pathVar = "id2") MultiValueMap<String, String> var2,
            Model model
            ) {
        model.addAttribute("data1", "@MatrixVariable 예제 - 여러 개의 매트릭스 변수 처리");
        model.addAttribute("data2", "첫 번째 매트릭스 변수: " + var1 + "<br> 두 번째 매트릭스 변수: " + var2);
        return "viewPage";
    }
}
