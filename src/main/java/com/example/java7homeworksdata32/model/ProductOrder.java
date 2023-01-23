package com.example.java7homeworksdata32.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductOrder {

    @NotBlank
    @NotNull
    private String productName;

    @NotNull
    @Min(value = 1)
    private int amount;

    @Length(max = 10)
    private String customerPhoneNumber;
}
