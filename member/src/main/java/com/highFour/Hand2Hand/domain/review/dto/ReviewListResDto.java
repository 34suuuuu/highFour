package com.highFour.Hand2Hand.domain.review.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.highFour.Hand2Hand.domain.review.entity.Review;
import com.highFour.Hand2Hand.domain.review.entity.ReviewImg;

import lombok.Builder;

@Builder
public record ReviewListResDto (
	Long id,
	String contents,
	Long rating,
	List<String> imgUrls,
	Long memberId
){
	public static ReviewListResDto fromEntity(Review review, List<ReviewImg> reviewImgs) {
		List<String> imgUrls = reviewImgs.stream().map(ReviewImg::getImgUrl).toList();

		return ReviewListResDto.builder()
			.id(review.getId())
			.contents(review.getContents())
			.rating(review.getRating())
			.memberId(review.getMemberId())
			.imgUrls(imgUrls)
			.build();
	}

}
