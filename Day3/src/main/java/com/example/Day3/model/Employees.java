package com.example.Day3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;

@AllArgsConstructor
@Data

public class Employees {

    @NotNull(message = "Please do not leave empty")
    @Range(min = 2, message = "Cannot be less than 2")
    private Integer ID;

    @NotEmpty(message = "Please do not leave empty")
    @Size(min = 4, message = "Most be more than 4 character")
    private String name;

    @NotNull(message = "Please do not leave empty")
    @Range(min = 25, message = "Cannot be less than 2")
    private Integer age;


    private boolean onLeave = false;

    @NotNull(message = "Please do not leave empty")
    private Data employmentYear;

    @NotNull(message = "Cant be null")
    private Integer annualLeave; // رصيد الايام

}
