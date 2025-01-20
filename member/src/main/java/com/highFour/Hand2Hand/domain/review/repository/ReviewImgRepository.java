package com.highFour.Hand2Hand.domain.review.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.highFour.Hand2Hand.domain.review.entity.ReviewImg;

public interface ReviewImgRepository extends JpaRepository<ReviewImg, Long> {
	List<ReviewImg> findAllByReviewId(Long id);
}
