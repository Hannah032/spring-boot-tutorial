package com.springBoot.domain;

import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Member {
    @MemberId(message = "admin은 안됩니다.")
    private String memberId;
    @Size(min=4, max=10, message="4~10 글자 이여야 해요")
    private String passwd;
}
