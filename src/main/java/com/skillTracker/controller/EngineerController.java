package com.skillTracker.controller;

import com.skillTracker.model.*;
import com.skillTracker.service.EngineerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/skill-tracker/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class EngineerController {
    @Autowired
    EngineerService engineerService;

    /**
     * API to register user
     *
     * @param user
     * @return UserResponse
     */
    @PostMapping("/engineer/add-profile")
    public ResponseEntity<UserResponse> addProfile(@RequestBody @Valid User user) {
        return engineerService.registerUser(user);
    }

    /**
     * API to update Profile
     *

     * @param userId
     * @param skills
     * @return UpdateResponse
     */
    @PutMapping("/engineer/update-profile/{userId}")
    public ResponseEntity<UpdateResponse> updateProfile(@PathVariable("UserId") Integer userId, @RequestBody Skills skills) {
        return engineerService.updateProfile(userId, skills);
    }



}
