/**
* Created for sending back successful response
*
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.dto;

public class StatusResponse<T> {

	
	public Boolean status;
	public int statusCode;
	public T data;
	
	public StatusResponse(Boolean status,int statusCode,T data){
		this.status = status;
		this.statusCode = statusCode;
		this.data = data;
		
	}
	
	public StatusResponse() {
	}

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
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
