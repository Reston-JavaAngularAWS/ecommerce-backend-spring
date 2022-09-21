package com.ecommerce.maven.exception;

public class ApplicationException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Internal Database Server Error!! Please try again later!!";
	}
}
