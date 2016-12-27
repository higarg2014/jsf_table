package com.donriver.exception;

public class CustomException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public CustomException(String message) {
		super(message);
		this.message = message;
	}
	
	

}
