package com.skillTracker.service;

import com.skillTracker.model.SearchResponse;
import org.springframework.http.ResponseEntity;

public interface AdminService {
    ResponseEntity<SearchResponse> searchProfile(String criteria, String criteriaValue);
}
