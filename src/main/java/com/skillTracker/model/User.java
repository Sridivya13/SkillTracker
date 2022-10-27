package com.skillTracker.model;

import lombok.*;

import javax.validation.constraints.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class User {

    @NotEmpty(message = "user Name should not be empty")
    @Min(value = 5, message = "UserName should be minimum of 5 characters")
    @Max(value = 30, message = "UserName should be maximum of 30 characters")
    private String userName;

    @NotEmpty(message = "Please provide a valid email address")
    @Email(message = "Please provide a valid email address")
    @Pattern(regexp=".+@.+\\..+", message="Please provide a valid email address")
    private String email;

    @Pattern(regexp="[\\d]{10}")
    private long mobileNumber;

    @NotEmpty(message = "Associate Id should not be empty")
    @Pattern(regexp = "^CTS.*$", message = "ID must start with TX", flags = Pattern.Flag.CASE_INSENSITIVE)
    @Min(value = 5, message = "AssociateId should be minimum of 5 characters")
    @Max(value = 30, message = "AssociateId should be maximum of 30 characters")
    private String associateId;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer hTMLCssJavascript;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer angular;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer react;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer spring;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer restful;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer hibernate;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer git;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer docker;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer jenkins;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer aws;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer spoken;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer communication;

    @NotEmpty(message = "Skill Should not be empty")
    @Pattern(regexp="[\\d]")
    @Min(value = 0, message = "Skill should have minimum value of 0")
    @Max(value = 20, message = "Skill should have maximum value of 20")
    private Integer aptitude;




}
