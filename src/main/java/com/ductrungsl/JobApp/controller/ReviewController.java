package com.ductrungsl.JobApp.controller;

import com.ductrungsl.JobApp.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}/reviews")
@RequiredArgsConstructor
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;
}
