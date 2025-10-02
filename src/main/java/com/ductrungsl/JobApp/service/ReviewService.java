package com.ductrungsl.JobApp.service;

import com.ductrungsl.JobApp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;
}
