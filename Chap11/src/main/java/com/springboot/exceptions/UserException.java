package com.springboot.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "사용자를 찾을 수 없습니다.")
public class UserException extends RuntimeException {
    public UserException(String message) {
        super(message);
        System.out.println(message);
    }
}
