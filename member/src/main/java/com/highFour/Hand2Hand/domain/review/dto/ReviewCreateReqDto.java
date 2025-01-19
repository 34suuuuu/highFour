package com.highFour.Hand2Hand.domain.review.dto;

import java.util.List;

import com.highFour.Hand2Hand.domain.review.entity.Review;

import lombok.Builder;

@Builder
public record ReviewCreateReqDto(
	Long productId,
	Long rating,
	String contents,
	List<String> imgUrls
	) {

	public Review toEntity(Long productId){
		return Review.builder()
			.productId(productId)
			.rating(this.rating)
			.contents(this.contents)
			.build();
	}

}
