package com.example.Day3.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


 @AllArgsConstructor @Data
public class Park {


    @NotNull(message = "Please do not leave empty")
    @Range(min = 2, message = "Cannot be less than 2")
    private Integer rideID;


    @NotEmpty(message = "Please do not leave empty")
    @Size(min = 4, message = "Name most not be less than 4 characters")
    private String rideName;


    @NotEmpty(message = "Please do not leave empty")
    @Pattern(regexp = "(Rollercoaster|thriller|water)", message = "use only Rollercoaster or thriller or water")
    private String rideType;

    @NotNull(message = "Please do not leave empty")
    private Integer tickets=0;

    @NotNull(message = "Please do not leave empty")
    private Integer price;

     }

