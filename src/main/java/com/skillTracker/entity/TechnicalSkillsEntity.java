package com.skillTracker.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Document(collection = "technicalSkills")
public class TechnicalSkillsEntity implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "technicalSkills";
    private static final long serialVersionUID = 955728933773177564L;
    @Id
    private Integer technicalSkillsId;
    private Integer userId;
    private Integer hTMLCssJavascript;
    private Integer angular;
    private Integer react;
    private Integer spring;
    private Integer restful;
    private Integer hibernate;
    private Integer git;
    private Integer docker;
    private Integer jenkins;
    private Integer aws;
}
