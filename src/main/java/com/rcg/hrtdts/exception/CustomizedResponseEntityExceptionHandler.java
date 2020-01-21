
package com.rcg.hrtdts.exception;


import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.utility.Constants;




@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	@SuppressWarnings({ "rawtypes", "unchecked" })
    @ExceptionHandler(HRTDTSException.class)
    public final ResponseEntity<StatusResponse> handleHRTDTSException(HRTDTSException ex, WebRequest request) {
        StatusResponse response = new StatusResponse();   
        ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage(), new Date());
        response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionResponse);
        return new ResponseEntity<StatusResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
    }
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(HRTDTSNotFoundException.class)
	public final ResponseEntity<StatusResponse> handleNotFoundException(HRTDTSNotFoundException ex, WebRequest request) {
		StatusResponse response = new StatusResponse();
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage(), new Date());
        response = new StatusResponse(Constants.FAILURE, HttpStatus.NOT_FOUND.value(), exceptionResponse);
        return new ResponseEntity<StatusResponse>(response,HttpStatus.NOT_FOUND);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@ExceptionHandler(HRTDTSDateFormatException.class)
	public final ResponseEntity<StatusResponse> handleDateFormatException(HRTDTSDateFormatException ex, WebRequest request) {
		StatusResponse response = new StatusResponse();			
		ExceptionResponse exceptionResponse = new ExceptionResponse(ex.getErrorCode(), ex.getErrorMessage(), new Date());
        response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionResponse);
        return new ResponseEntity<StatusResponse>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
