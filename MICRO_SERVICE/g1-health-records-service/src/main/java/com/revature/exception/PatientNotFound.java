package com.revature.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND) // 404
public class PatientNotFound extends RuntimeException {
	private String message;

	public PatientNotFound(String message) {
		super(message);
		this.message = message;
	}

}

