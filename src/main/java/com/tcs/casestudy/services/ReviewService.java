package com.tcs.casestudy.services;

import java.util.Optional;

import com.tcs.casestudy.models.Review;

public interface ReviewService {
	public Review addReview(Review review);
	public String updateReview(long id, Review updateReview);
	public String deleteReview(long id);
	public Optional<Review> findByProductId(long productId);
}
