package com.springBoot.domain;

import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class Person {
    private String name;

    private String age;
    @Email(message = "이메일 형식이 아닙니다.")
    private String email;

}
