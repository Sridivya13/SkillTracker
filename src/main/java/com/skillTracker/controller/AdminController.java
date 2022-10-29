package com.skillTracker.controller;



import com.skillTracker.model.SearchResponse;
import com.skillTracker.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skill-tracker/api/v1/admin/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@Slf4j
public class AdminController {

    @Autowired

    AdminService adminService;

    /**

     * API to Search Profile for Admin

     *

     * @param criteria

     * @param criteriaValue

     * @return TweetResponse

     */

    @GetMapping("{criteria}/{criteriaValue}")

    public ResponseEntity<SearchResponse> searchProfile(@PathVariable("criteria") String criteria, @PathVariable("criteriaValue") String criteriaValue) {

        return adminService.searchProfile(criteria, criteriaValue);
    }
}









