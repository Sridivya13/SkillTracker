package com.skillTracker.service;

import com.skillTracker.model.*;
import org.springframework.http.ResponseEntity;

public interface EngineerService {
    ResponseEntity<UserResponse> registerUser(User user);

    ResponseEntity<UpdateResponse> updateProfile(Integer userId, Skills skills);


}

