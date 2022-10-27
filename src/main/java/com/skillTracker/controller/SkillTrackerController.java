package com.skillTracker.controller;

import com.skillTracker.model.*;
import com.skillTracker.service.AddProfile;
import io.micrometer.core.instrument.search.Search;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/skill-tracker/api/v1")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class SkillTrackerController {
    @Autowired
    AddProfile addProfile;

    /**
     * API to register user
     *
     * @param user
     * @return UserResponse
     */
    @PostMapping("/engineer/add-profile")
    public ResponseEntity<UserResponse> addProfile(@RequestBody @Valid User user) {
        log.info("Register User");
        return addProfile.registerUser(user);
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
        return addProfile.updateProfile(userId, skills);
    }

    /**
     * API to Search Profile for Admin
     *

     * @param criteria
     * @param criteriaValue
     * @return TweetResponse
     */
    @GetMapping("/skill-tracker/api/v1/admin/{criteria}/{criteriaValue}")
    public ResponseEntity<SearchResponse> searchProfile(@PathVariable("criteria") String criteria, @PathVariable("criteriaValue") String criteriaValue) {
        return addProfile.searchProfile(criteria, criteriaValue);
    }


}
