package com.skillTracker.service;

import com.skillTracker.model.*;
import org.springframework.http.ResponseEntity;

public interface AddProfile {
    ResponseEntity<UserResponse> registerUser(User user);

    ResponseEntity<UpdateResponse> updateProfile(Integer userId, Skills skills);

    ResponseEntity<SearchResponse> searchProfile(String criteria, String criteriaValue);
}

