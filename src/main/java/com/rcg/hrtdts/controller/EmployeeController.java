package com.rcg.hrtdts.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.EmployeeRequestDto;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.EmployeeService;
import com.rcg.hrtdts.utility.Constants;

/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
@RestController
@RequestMapping(value = { "/employee" })
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/hrt-information"))
	@ResponseBody
	public StatusResponse setUserHrtInformation(@RequestBody EmployeeRequestDto requestDto){
		StatusResponse response = new StatusResponse();
		try {		
			response = employeeService.saveEmployeeInfo(requestDto);
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionResponse);
		}
		return response;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/pre-data-information")
	@ResponseBody
	public StatusResponse getPreDataInfo() {
		
		StatusResponse response = new StatusResponse();
		try {		
			response = employeeService.getSkillsAndReferrals();
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionResponse);
		}
		return response;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/hrt-information/{id}")
	@ResponseBody
	public StatusResponse getUserHrtInformation(@PathVariable long id) {
		
		StatusResponse response = new StatusResponse();
		try {		
			response = employeeService.getUserHrtInfo(id);
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionResponse);
		}
		return response;
	}
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping(value = "/hrt-information")
	@ResponseBody
	public StatusResponse getUserListInformation() {
		
		StatusResponse response = new StatusResponse();
		try {		
			response = employeeService.getEmployeeList();
		}
		catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(1234, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionResponse);
		}
		return response;
	}

	
}
