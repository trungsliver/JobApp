package com.ductrungsl.JobApp.controller;

import com.ductrungsl.JobApp.entity.Review;
import com.ductrungsl.JobApp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public ResponseEntity<String> addReview(@PathVariable Long companyId, @RequestBody Review review) {
        reviewService.addReview(companyId, review);
        return new ResponseEntity<>("Review added successfully", HttpStatus.CREATED);
    }

}
