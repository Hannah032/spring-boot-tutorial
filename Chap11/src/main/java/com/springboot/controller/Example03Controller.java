package com.springboot.controller;

import com.springboot.exceptions.UserException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Example03Controller {

    @GetMapping("/exam03")
    public void requestMethod() {
        throw new UserException("UserException 메세지입니다.");
    }

    //    // 실제 사용 예제
//    @GetMapping("/exam03-1")
//    public String requestMethod2() {
//        if (조건절) {
//            throw new UserException("UserException 메시지입니다.");
//        }
//        return "viewPage03-1";
//    }

    @ExceptionHandler(UserException.class)
    public String handleUserException(UserException ex, Model model) {
        model.addAttribute("data1", ex.getMessage());
        model.addAttribute("data2", ex);
        return "viewPage";
    }
}
