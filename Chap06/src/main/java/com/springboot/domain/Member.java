package com.springboot.domain;

import lombok.Data;

@Data
public class Member {
    private String id;
    private String passwd;
    private String city;
    private String sex;
    private String[] hobby;
    private String greeting;
}
