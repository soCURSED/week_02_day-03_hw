package com.example.Day3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.*;

@AllArgsConstructor @Data
public class Student {

    @NotNull(message = "Please do not leave empty")
    private Integer id;

    @NotEmpty(message = "Please do not leave empty")
    @Size(min = 6, message = "Name most not be less than 2 characters")
    private String name;

    @NotNull(message = "Please do not leave empty")
    @Range(min = 17, message ="Most be 18 years or older")
    private Integer age;

    @NotEmpty(message = "Please do not leave empty")
    @Email(message = "Please send a valid email")
    private String email;



}
