package com.springBoot.Chap10.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class Example02Controller {
    @GetMapping("/exam02")
    public String requestMethod(Model model) {
        return "redirect:/member/user";
    }

//    @GetMapping("/member/user")
//    public String requestMethod2(Authentication authentication, Model model) {
//        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//        String username = userDetails.getUsername();
//        String password = userDetails.getPassword();
//        boolean isAuthenticated = authentication.isAuthenticated(); // 인증 여부 확인
//
//        model.addAttribute("data1", "/manager/user");
//        model.addAttribute("data2", username);
//        model.addAttribute("data3", password);
//
//        Collection<? extends GrantedAuthority>authorities = userDetails.getAuthorities();
//        for (GrantedAuthority item : authorities) {
//            model.addAttribute("data4", item + " "); // 권한들
//        }
//        model.addAttribute("data5", isAuthenticated);   // 인증 여부
//
//        return "viewPage02";
//    }

    @GetMapping("/member/user")
    public String securityContextHolderMethod(Model model) {
        SecurityContext context = SecurityContextHolder.getContext();
        Authentication authentication = context.getAuthentication();
        String username = authentication.getName(); // 사용자 이름
        Object principal = authentication.getPrincipal(); // 사용자 정보 객체
        boolean isAuthenticated = authentication.isAuthenticated(); // 인증 여부 확인

        model.addAttribute("data1", "/manager/user");
        model.addAttribute("data2", username);
        model.addAttribute("data3", "");

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority item : authorities) {
            model.addAttribute("data4", item + " "); // 권한들
        }
        model.addAttribute("data5", isAuthenticated);   // 인증 여부
        return "viewPage02";
    }
}


