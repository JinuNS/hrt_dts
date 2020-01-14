package com.rcg.hrtdts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.UserHrtDto;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.UserHrtService;

@RestController
@RequestMapping(value = { "/hrtdts" })
public class UserHrtController {
	
	@Autowired
	private UserHrtService hrtService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/hrt-information"))
	@ResponseBody
	public StatusResponse setUserHrtInformation(@RequestBody UserHrtDto requestDto){
		StatusResponse response = new StatusResponse();
		try {		
			response = hrtService.saveNewHrt(requestDto);
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse("Failed", 500, exceptionResponse);
		}
		return response;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/pre-data-information")
	@ResponseBody
	public StatusResponse getPreDataInfo() {
		
		StatusResponse response = new StatusResponse();
		try {		
			response = hrtService.getSkillsAndReferrals();
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse("Failed", 500, exceptionResponse);
		}
		return response;
	}
	
	
}
