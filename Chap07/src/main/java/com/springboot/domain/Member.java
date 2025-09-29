package com.springboot.domain;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Member {
    private String name;
    private MultipartFile fileImage;
    
    // 기본 생성자 추가
    public Member() {}
    
    // 생성자 추가
    public Member(String name, MultipartFile fileImage) {
        this.name = name;
        this.fileImage = fileImage;
    }
}
