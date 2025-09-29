package com.springboot.controller;

import com.springboot.domain.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Exam02Controller {

    @PostMapping("/member")
    public String submitMember(@ModelAttribute Member member, Model model) {
        model.addAttribute("member",member);
        //return "viewPage02";
        return "redirect:/login";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // id, passwd, city, sex, greetings 필드만 바인딩 허용
        binder.setAllowedFields("hobby");  // hobby 제외
    }
}
