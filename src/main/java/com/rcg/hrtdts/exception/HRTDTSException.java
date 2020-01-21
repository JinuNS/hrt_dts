/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-15 
*/

package com.rcg.hrtdts.exception;

public class HRTDTSException extends RuntimeException{

	public static final int defaultAppErrorCode = 100;
	public static final String defaultMessage = "Exception Throwned from HRT-DTS Application";
	
	public String errorMessage;
	public int errorCode;
	
	public HRTDTSException() {
		setErrorCode(defaultAppErrorCode);
		setErrorMessage(defaultMessage);  
	}
	
	public HRTDTSException(int errorCode, String message) {
		setErrorCode(errorCode);
		setErrorMessage(message);  
	}
	
	public HRTDTSException(String message) {
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
