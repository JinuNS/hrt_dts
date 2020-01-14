package com.rcg.hrtdts.exception;

public class PMSException extends RuntimeException{

	public static final int defaultAppErrorCode = 12345;
	public static final String defaultMessage = "Exception Throwned from PMSProjet";
	
	public String errorMessage;
	public int errorCode;
	
	public PMSException() {
		setErrorCode(defaultAppErrorCode);
		setErrorMessage(defaultMessage);  
	}
	
	public PMSException(int errorCode, String message) {
		setErrorCode(errorCode);
		setErrorMessage(message);  
	}
	
	public PMSException(String message) {
		setErrorCode(defaultAppErrorCode);
		setErrorMessage(message);  
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
