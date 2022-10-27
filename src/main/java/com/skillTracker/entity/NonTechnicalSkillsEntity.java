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
@Document(collection = "nonTechnicalSkills")
public class NonTechnicalSkillsEntity implements Serializable {

    @Transient
    public static final String SEQUENCE_NAME = "nonTechnicalSkills";
    private static final long serialVersionUID = 955728933773177564L;
    @Id
    private Integer nonTechnicalSkillsId;
    private Integer userId;
    private Integer spoken;
    private Integer communication;
    private Integer aptitude;
}
