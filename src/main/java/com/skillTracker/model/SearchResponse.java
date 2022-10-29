package com.skillTracker.model;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class SearchResponse {
    private List<User> userList;
    private String messageType;
    private HttpStatus messageCode;
    private String message;
}

