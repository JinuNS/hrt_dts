package com.rcg.hrtdts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.StatusResponse;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.service.HrtDtsService;

@RestController
@RequestMapping(value = { "/hrtdts" })
public class LoginController{

	@Autowired
	HrtDtsService hrtDtsService;
	
	/**
	 * To get the user information
	 * @author  Jinu Shaji
	 * @version 1.0
	 * @since   2020-01-10 
	 * 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/user-information"))
	public StatusResponse getUserInformation(@RequestBody RequestDto requestDto){
		StatusResponse response = new StatusResponse();
		try {		
			response = hrtDtsService.getUserInfo(requestDto);
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse(false, 500, exceptionResponse);
		}
		return response;
	}

}
