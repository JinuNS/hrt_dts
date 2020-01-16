/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-15 
*/


package com.rcg.hrtdts.exception;

public class HRTDTSNotFoundException extends HRTDTSException{

	public static final int defaultAppErrorCode = 12404;
	public static final String defaultMessage = "The link you followed may be broken, or the page may have been removed";
	
	public String errorMessage;
	public int errorCode;
	
	public HRTDTSNotFoundException() {
		setErrorCode(errorCode);
		setErrorMessage(defaultMessage);  
	}
	
	public HRTDTSNotFoundException(int errorCode, String message) {
		setErrorCode(errorCode);
		setErrorMessage(message);  
	}
	
	public HRTDTSNotFoundException(String message) {
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
