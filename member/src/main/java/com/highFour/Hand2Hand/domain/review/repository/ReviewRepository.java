package com.highFour.Hand2Hand.domain.review.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.highFour.Hand2Hand.domain.review.entity.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
	Optional<Review> findByProductId(Long productId);
}
