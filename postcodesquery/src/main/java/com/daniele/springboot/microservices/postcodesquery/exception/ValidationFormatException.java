package com.daniele.springboot.microservices.postcodesquery.exception;

public class ValidationFormatException extends Exception {

	private static final long serialVersionUID = -3332292346834265371L;
	
	public ValidationFormatException(String mex) {
		super(mex);
	}

}
