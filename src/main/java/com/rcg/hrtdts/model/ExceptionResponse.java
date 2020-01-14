/**
* Created for setting error response
*
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.model;

import java.util.Date;

public class ExceptionResponse {

	public int errorCode;
	public String errorMessage;
	public Date timestamp;

	public ExceptionResponse(int errorCode, String errorMessage, Date timestamp) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.timestamp = timestamp;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

}
