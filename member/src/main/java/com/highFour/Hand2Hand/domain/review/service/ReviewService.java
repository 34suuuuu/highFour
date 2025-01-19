package com.highFour.Hand2Hand.domain.review.service;

import static com.highFour.Hand2Hand.common.exceptionType.ReviewExceptionType.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highFour.Hand2Hand.common.exception.BaseCustomException;
import com.highFour.Hand2Hand.domain.review.dto.ReviewCreateReqDto;
import com.highFour.Hand2Hand.domain.review.entity.Review;
import com.highFour.Hand2Hand.domain.review.repository.ReviewImgRepository;
import com.highFour.Hand2Hand.domain.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final ReviewImgRepository reviewImgRepository;

	@Transactional
	public void createReview(Long productId, ReviewCreateReqDto reqDto) {
	// 	productRepository에서 물품 정보 존재하는지 확인


		// 이미 리뷰가 존재하는지 확인
		if (reviewRepository.findByProductId(productId).isPresent()) {
			throw new BaseCustomException(REVIEW_ALREADY_EXIST);
		}

		Review review = reqDto.toEntity(productId);
		reviewRepository.save(review);
	}
}
