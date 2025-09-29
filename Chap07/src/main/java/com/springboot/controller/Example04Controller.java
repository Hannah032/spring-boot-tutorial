package com.springboot.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/exam04")
public class Example04Controller {
    @GetMapping
    public String photoDownload(Model model) {
        return "viewPage02";  // 뷰 이름 반환 (viewPage02.html)
    }

    @GetMapping("/download")
    public void photoDownload(
            @RequestParam("file") String paramKey,
            HttpServletResponse response) throws IOException {
        // 파일 경로 설정
        File f = new File("C:\\uploads\\" + paramKey);

        // 파일 다운로드 설정
        response.setContentType("application/download");
        response.setContentLength((int)f.length());
        response.setHeader("Content-disposition", "attachment;filename=\"" + paramKey + "\"");
        // 파일 전송
        OutputStream os = response.getOutputStream();
        FileInputStream fis = new FileInputStream(f);
        FileCopyUtils.copy(fis, os);
        fis.close();
        os.close();
    }
}
