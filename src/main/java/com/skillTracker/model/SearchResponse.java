package com.skillTracker.model;

import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Skills {

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
