package com.tcs.casestudy.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tcs.casestudy.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {

}
