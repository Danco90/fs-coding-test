package com.daniele.springboot.microservices.postcodesquery.exception;

public class RemoteResourceReadTimeoutException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RemoteResourceReadTimeoutException(Throwable cause) {
		super("Response timeout. Failed to get remote resource , cause : " + cause);
	}
	
	
}
