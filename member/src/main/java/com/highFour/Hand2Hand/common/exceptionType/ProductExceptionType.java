package com.highFour.Hand2Hand.common.exceptionType;

import org.springframework.http.HttpStatus;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum ProductExceptionType implements ExceptionType{
	PRODUCT_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 물품입니다.");

	private final HttpStatus httpStatus;
	private final String message;

	@Override
	public HttpStatus httpStatus() {
		return httpStatus;
	}

	@Override
	public String message() {
		return message;
	}

}
