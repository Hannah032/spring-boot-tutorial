package com.springBoot.domain;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Product {
    @NotEmpty
    @Size(min = 4, max = 10, message="4~10 글자")
    private String name;

    @Min(value = 0, message="0 이상의 값")
    private int price;
}
