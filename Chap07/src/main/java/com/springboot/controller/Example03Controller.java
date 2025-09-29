package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

@Controller
@RequestMapping("/exam03")
public class Example03Controller {
    @GetMapping("/form")
    public String requestForm() {
        return "viewPage";  // 뷰 이름 반환 (viewPage.html)
    }
    @PostMapping("/form")
    public String submitForm(MultipartHttpServletRequest request, Model model) {
        String name = request.getParameter("name");
        MultipartFile file = request.getFile("fileImage");

        if (file != null && !file.isEmpty()) {
            String fileName = file.getOriginalFilename(); // 업로드된 파일명
            File saveFile = new File("C:\\uploads\\" + name + "_" + fileName);  // 이름_오리지널파일이름 -> 저장할 파일 경로 및 이름

            try {
                file.transferTo(saveFile);  // 업로드된 파일을 지정한 경로에 저장

                model.addAttribute("data1", "MultipartHttpServletRequest 사용");
                model.addAttribute("data2", fileName);
                model.addAttribute("data3", saveFile.getName());
                model.addAttribute("data4", URLEncoder.encode(saveFile.getName(), StandardCharsets.UTF_8));
            } catch(IOException e) {
                e.printStackTrace();
                model.addAttribute("error", "파일 업로드 중 오류가 발생했습니다: " + e.getMessage());
            }
        } else {
            model.addAttribute("error", "파일이 선택되지 않았습니다.");
        }

        return "viewPage_process"; // 뷰 이름 반환 (viewPage_process.html)
    }
}
