package com.highFour.Hand2Hand.domain.review.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.highFour.Hand2Hand.domain.review.dto.ReviewCreateReqDto;
import com.highFour.Hand2Hand.domain.review.dto.ReviewListResDto;
import com.highFour.Hand2Hand.domain.review.service.ReviewService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/review")
@RestController
@RequiredArgsConstructor
public class ReviewController {

	private final ReviewService reviewService;

	@PostMapping("/{productId}/create")
	public ResponseEntity<?> createReview(@PathVariable Long productId,
		@RequestBody ReviewCreateReqDto reqDto) {
		reviewService.createReview(productId, reqDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	// 상품별 리뷰 조회
	@GetMapping("/{productId}/list")
	public ResponseEntity<?> getReviewList(@PathVariable Long productId) {
		List<ReviewListResDto> reviews = reviewService.getReviewsByProductId(productId);
		return ResponseEntity.status(HttpStatus.OK).body(reviews);
	}

	// 사용자별 리뷰 조회
}
