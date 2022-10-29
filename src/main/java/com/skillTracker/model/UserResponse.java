package com.skillTracker.model;

import lombok.*;
import org.springframework.http.HttpStatus;


@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class UserResponse {

    private int userId;
    private String messageType;
    private HttpStatus messageCode;
    private String message;


}

