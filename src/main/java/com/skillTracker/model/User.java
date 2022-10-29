package com.skillTracker.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @NotEmpty(message = "user Name should not be empty")
    @Length(min = 5, message = "UserName should be minimum of 5 characters")
    @Length(max = 30, message = "UserName should be maximum of 30 characters")
    private String userName;

    @NotEmpty(message = "Please provide a valid email address")
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    //@Pattern(regexp="[\\d]{10}")
    private long mobileNumber;

    @NotEmpty(message = "Associate Id should not be empty")
    @Pattern(regexp = "^CTS.*$", message = "ID must start with TX", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Length (min = 5, message = "AssociateId should be minimum of 5 characters")
    @Length(max = 30, message = "AssociateId should be maximum of 30 characters")
    private String associateId;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer hTMLCssJavascript;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer angular;

    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer react;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer spring;

    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer restful;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer hibernate;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer git;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer docker;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer jenkins;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer aws;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer spoken;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer communication;


    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer aptitude;




}
