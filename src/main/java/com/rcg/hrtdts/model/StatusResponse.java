/**
* Created for sending back successful response
*
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.model;

public class StatusResponse<T> {
	
	public String status;
	public int statusCode;
	public T data;
	
	public StatusResponse(String status,int statusCode,T data){
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
	}
	
	public StatusResponse() {
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
