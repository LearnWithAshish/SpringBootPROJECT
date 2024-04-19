package com.demo.customException;

public class buisnessException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errorCodeString;
	private String errorMessage;
	public String getErrorCodeString() {
		return errorCodeString;
	}
	public void setErrorCodeString(String errorCodeString) {
		this.errorCodeString = errorCodeString;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public buisnessException(String errorCodeString, String errorMessage) {
		super();
		this.errorCodeString = errorCodeString;
		this.errorMessage = errorMessage;
	}
	public buisnessException() {
		super();
	}

}
