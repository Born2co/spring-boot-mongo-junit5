package com.springboot.mongodb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Booking ID Not Found")
public class BookingException extends RuntimeException{
	
	private static final long serialVersionUID = -8200569022290568747L;

	public BookingException(String message) {
		super(message);
	}
	
}
