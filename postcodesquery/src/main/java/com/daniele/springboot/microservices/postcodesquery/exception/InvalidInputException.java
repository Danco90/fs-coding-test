package com.daniele.springboot.microservices.postcodesquery.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

public class InvalidInputException extends HttpClientErrorException {

	private static final long serialVersionUID = -3332292346834265371L;
	
	public InvalidInputException(HttpStatus statusCode, String statusText) {
		super(statusCode, statusText);
	}

}
