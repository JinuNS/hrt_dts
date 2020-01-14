/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-14 
*/


package com.rcg.hrtdts.exception;

public class PMSNotFoundException extends PMSException{

	public static final int defaultAppErrorCode = 12404;
	public static final String defaultMessage = "The link you followed may be broken, or the page may have been removed";
	
	public String errorMessage;
	public int errorCode;
	
	public PMSNotFoundException() {
		setErrorCode(errorCode);
		setErrorMessage(defaultMessage);  
	}
	
	public PMSNotFoundException(int errorCode, String message) {
		setErrorCode(errorCode);
		setErrorMessage(message);  
	}
	
	public PMSNotFoundException(String message) {
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
