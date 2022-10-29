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
