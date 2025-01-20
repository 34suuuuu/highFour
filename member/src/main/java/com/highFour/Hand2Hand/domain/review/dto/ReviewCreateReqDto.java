package com.highFour.Hand2Hand.domain.review.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.highFour.Hand2Hand.domain.review.entity.Review;
import com.highFour.Hand2Hand.domain.review.entity.ReviewImg;

import lombok.Builder;

@Builder
public record ReviewCreateReqDto(
	Long productId,
	Long memberId,
	Long rating,
	String contents,
	List<String> imgUrls
	) {

	public Review toEntity(Long productId){
		return Review.builder()
			.productId(productId)
			.rating(this.rating)
			.memberId(this.memberId)
			.contents(this.contents)
			.build();
	}

	public List<ReviewImg> toReviewImgs(Review review) {
		return imgUrls.stream()
			.map(imgUrl -> ReviewImg.builder()
				.review(review)
				.imgUrl(imgUrl)
				.build())
			.collect(Collectors.toList());
	}

}
