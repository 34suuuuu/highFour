package com.highFour.Hand2Hand.common.exceptionType;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ReviewExceptionType implements ExceptionType{
	REVIEW_ALREADY_EXIST(HttpStatus.INTERNAL_SERVER_ERROR, "이 물품에 대한 리뷰가 이미 존재합니다."),
	REVIEW_NOT_FOUND(HttpStatus.NOT_FOUND, "이 물품에 대한 리뷰가 존재하지 않습니다.");

	private final HttpStatus status;
	private final String message;

	@Override
	public HttpStatus httpStatus() {
		return status;
	}

	@Override
	public String message() {
		return message;
	}
}
