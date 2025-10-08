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

    public boolean addReview(Long companyId, Review review) {
        Company company = companyService.findById(companyId);
        if (company != null) {
            review.setCompany(company);
            reviewRepository.save(review);
            return true;
        }
        return false;
    }

    public Review findReviewById(Long companyId, Long reviewId) {
        List<Review> reviews = reviewRepository.findByCompanyId(companyId);
        return reviews.stream()
                .filter(review -> review.getId().equals(reviewId))
                .findFirst()
                .orElse(null);
    }

    public boolean updateReviewById(Long companyId, Long reviewId, Review review) {
        Review existingReview = findReviewById(companyId, reviewId);
        if (existingReview != null) {
            existingReview.setTitle(review.getTitle());
            existingReview.setDescription(review.getDescription());
            existingReview.setRating(review.getRating());
            reviewRepository.save(existingReview);
            return true;
        }
        return false;
    }

    public  boolean deleteReviewById(Long companyId, Long reviewId) {
        Review existingReview = findReviewById(companyId, reviewId);
        if (existingReview != null) {
            reviewRepository.delete(existingReview);
            return true;
        }
        return false;
    }
}
