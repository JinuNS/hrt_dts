/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-15 
*/


package com.rcg.hrtdts.exception;

public class HRTDTSDateFormatException extends HRTDTSException{

	public static final int defaultAppErrorCode = 102;
	public static final String defaultMessage = "Invalid date format!";
	
	public String errorMessage;
	public int errorCode;
	
	public HRTDTSDateFormatException() {
		setErrorCode(errorCode);
		setErrorMessage(defaultMessage);  
	}
	
	public HRTDTSDateFormatException(int errorCode, String message) {
		setErrorCode(errorCode);
		setErrorMessage(message);  
	}
	
	public HRTDTSDateFormatException(String message) {
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
