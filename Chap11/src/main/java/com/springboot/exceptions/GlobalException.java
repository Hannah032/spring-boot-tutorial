package com.springboot.exceptions;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackages = "com.springboot")
public class GlobalException {
    @ExceptionHandler(value = {RuntimeException.class})
    private String handleException(Exception ex, Model model) {
        model.addAttribute("data1", "GlobalException 메세지입니다.");
        model.addAttribute("data2", ex);
        return "viewPage";
    }
}
