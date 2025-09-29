package com.springBoot.domain;

import jakarta.validation.Constraint;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = {MemberIdValidator.class})
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberId {
    String message() default "아이디는 null이 아니거나 admin이 아니여야 해요";
    Class<?>[] groups() default {};
    Class<?>[] payload() default {};
}
