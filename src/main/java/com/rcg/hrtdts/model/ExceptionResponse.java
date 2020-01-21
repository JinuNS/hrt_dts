package com.rcg.hrtdts.model;

import java.util.Date;

public class ExceptionResponse {

	public Integer errorCode;
	public String errorMessage;
	public Date timestamp;

	public ExceptionResponse(Integer errorCode, String errorMessage, Date timestamp) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.timestamp = timestamp;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
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
