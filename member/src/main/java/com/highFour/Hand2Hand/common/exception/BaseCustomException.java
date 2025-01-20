package com.highFour.Hand2Hand.common.exception;

import com.highFour.Hand2Hand.common.exceptionType.ExceptionType;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class BaseCustomException extends RuntimeException{
	private final ExceptionType exceptionType;

	@Override
	public String getMessage() {
		return exceptionType.message();
	}
}
