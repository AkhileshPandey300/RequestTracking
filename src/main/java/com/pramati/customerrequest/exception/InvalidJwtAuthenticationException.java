package com.pramati.customerrequest.exception;

import org.springframework.security.core.AuthenticationException;

public class InvalidJwtAuthenticationException extends AuthenticationException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4334691275101730479L;

	public InvalidJwtAuthenticationException(String e) {
		super(e);
	}
}