package com.skillTracker.utils;

import java.util.List;

public class ServiceConstants {

    private ServiceConstants() {
    }

    public static final String TOPIC_NAME = "myKafkaTest";

    public static final String GROUP_ID = "group_id";

    public static final String FAILURE = "Failure";
    public static final String SUCCESS = "Success";
    public static final String USER_NOT_PRESENT = "User is not Present";
    public static final String USER_NOT_UPDATED = "User skills are not Updated";

    public static final String ERROR_SEARCH = "Error While Searching";
    public static final Integer TEN = 10;

    public static final List<String> technicalSkills = List.of("hTMLCssJavascript", "angular", "react", "spring", "restful", "hibernate", "git", "docker", "jenkins", "aws");
    public static final List<String> nonTechnicalSkills = List.of("spoken", "communication", "aptitude" );


    public static final String ID_CREATED = "Id Created";
  }

