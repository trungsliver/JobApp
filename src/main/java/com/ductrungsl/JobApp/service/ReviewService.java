package com.ductrungsl.JobApp.service;

import com.ductrungsl.JobApp.entity.Company;
import com.ductrungsl.JobApp.entity.Review;
import com.ductrungsl.JobApp.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    @Autowired
    private final ReviewRepository reviewRepository;
    @Autowired
    private final CompanyService companyService;

    public List<Review> findAll(Long companyId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews;
    }

    public void addReview(Long companyId, Review review) {
        Company company = companyService.findById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
        }
    }
}
