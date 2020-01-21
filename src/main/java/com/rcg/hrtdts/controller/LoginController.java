package com.rcg.hrtdts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.LoginService;
import com.rcg.hrtdts.utility.Constants;

/**
 * 
 * @author Renjith
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
@RestController
@RequestMapping(value = { "/hrtdts" })
public class LoginController {

	@Autowired
	private LoginService loginService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/login"))
	public StatusResponse getLoginCredentials(@RequestBody LoginDto requestDto) {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),loginService.getLoginCredentials(requestDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorCode(),e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionResponse);
		}
		return response;
	}

}
