package com.ductrungsl.JobApp.controller;

import com.ductrungsl.JobApp.entity.Review;
import com.ductrungsl.JobApp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    @GetMapping("")
    public ResponseEntity<List<Review>> getAllReviewsByCompanyId(@PathVariable Long companyId) {
        return new ResponseEntity<>(reviewService.findAll(companyId), HttpStatus.OK);
    }
}
