/**
* Created for sending back successful response
*
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.model;


/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public class StatusResponse<T> {

	public String status;
	public Integer statusCode;
	public T data;

	public StatusResponse(String status, Integer statusCode, T data) {
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

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
