/**
* Created for sending back error response
*
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/
package com.rcg.hrtdts.dto;

import com.rcg.hrtdts.model.ExceptionResponse;

public class ErrorResponse<T> {

	public Boolean status;
	public int statusCode;
	public ExceptionResponse data;
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public ExceptionResponse getData() {
		return data;
	}
	public void setData(ExceptionResponse data) {
		this.data = data;
	}
	
	
	
}
