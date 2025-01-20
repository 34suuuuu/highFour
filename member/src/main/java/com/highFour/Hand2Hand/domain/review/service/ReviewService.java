package com.highFour.Hand2Hand.domain.review.service;

import static com.highFour.Hand2Hand.common.exceptionType.ReviewExceptionType.*;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.highFour.Hand2Hand.common.exception.BaseCustomException;
import com.highFour.Hand2Hand.common.service.FileService;
import com.highFour.Hand2Hand.domain.review.dto.ReviewCreateReqDto;
import com.highFour.Hand2Hand.domain.review.dto.ReviewListResDto;
import com.highFour.Hand2Hand.domain.review.entity.Review;
import com.highFour.Hand2Hand.domain.review.entity.ReviewImg;
import com.highFour.Hand2Hand.domain.review.repository.ReviewImgRepository;
import com.highFour.Hand2Hand.domain.review.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewService {

	private final ReviewRepository reviewRepository;
	private final ReviewImgRepository reviewImgRepository;
	private final FileService fileService;

	@Transactional
	public void createReview(Long productId, ReviewCreateReqDto reqDto) {
	// 	productRepository에서 물품 정보 존재하는지 확인

		// 이미 사용자의 리뷰가 존재하는지 확인
		// if (reviewRepository.findByProductId(productId).isPresent()) {
		// 	throw new BaseCustomException(REVIEW_ALREADY_EXIST);
		// }

		// Review 저장
		Review review = reqDto.toEntity(productId);
		reviewRepository.save(review);

		// ReviewImg 리스트 저장
		List<ReviewImg> reviewImgs = reqDto.toReviewImgs(review);
		reviewImgRepository.saveAll(reviewImgs);
	}

	// 물품별 리뷰 조회
	@Transactional(readOnly = true)
	public List<ReviewListResDto> getReviewsByProductId(Long productId) {
		List<Review> reviews = reviewRepository.findAllByProductId(productId);
		return reviews.stream()
			.map(review -> {
				// 리뷰에 연결된 이미지들 조회
				List<ReviewImg> images = reviewImgRepository.findAllByReviewId(review.getId());
				return ReviewListResDto.fromEntity(review, images);
			})
			.collect(Collectors.toList());
	}

	// 	사용자별 리뷰 조회
}
