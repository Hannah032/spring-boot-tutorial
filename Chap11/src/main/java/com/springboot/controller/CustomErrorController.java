package com.springboot.controller;

import jakarta.servlet.http.HttpServlet;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {
    @RequestMapping("/custom-error")
    public String handleError(HttpServlet request, Model model) {
        model.addAttribute("data1", "글로벌 에러페이지");
        model.addAttribute("data2");
        return "viewPage";
    }

}
