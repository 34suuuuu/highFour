package com.highFour.Hand2Hand.common.exceptionType;

import org.springframework.http.HttpStatus;

public interface ExceptionType {
	String name();

	HttpStatus httpStatus();

	String message();
}
