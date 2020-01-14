package com.rcg.hrtdts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
import com.rcg.hrtdts.exception.PMSException;
import com.rcg.hrtdts.exception.PMSNotFoundException;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.HrtDtsService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = { "/hrtdts" })
public class SampleController{

	@Autowired
	HrtDtsService hrtDtsService;
	
	/**
	 * To get the user information
	 * @author  Jinu Shaji
	 * @version 1.0
	 * @since   2020-01-10 
	 * 
	 **/
	
	@ApiOperation(value = "View user information")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/user-information"))
	public StatusResponse getUserInformation(@RequestBody RequestDto requestDto){
		StatusResponse response = new StatusResponse();
		try {		
			response = hrtDtsService.getUserInfo(requestDto);
		}
		catch (PMSNotFoundException e) {
			throw new PMSException("PMSNotFoundException thrown from getUserInformation method");
		}
		catch (PMSException e) {
			throw new PMSException("PMSException thrown from getUserInformation method");
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse("failure", 500, exceptionResponse);
		}
		return response;
	}
	
	@ApiOperation(value = "saveUserInformation")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully saved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	}
			)
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/save"))
	public StatusResponse saveUserInformation(@RequestBody UserDto userDto){
		StatusResponse response = new StatusResponse();
		try {		
			response = hrtDtsService.saveUserInfo(userDto);
		}
		catch (PMSNotFoundException e) {
			throw new PMSNotFoundException("PMSNotFoundException thrown from saveUserInformation method");
		}
		catch (PMSException e) {
			throw new PMSException("PMSException thrown from saveUserInformation method");
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse("failure", 500, exceptionResponse);
		}
		return response;
	}
}
