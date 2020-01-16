package com.rcg.hrtdts.controller;

import java.util.Date;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.DtsRequestBody;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.DTSRepository;
import com.rcg.hrtdts.service.DTSService;
import com.rcg.hrtdts.utility.Constants;

@RestController
@RequestMapping(value="/DTS")
public class DTSController {
	
	@Autowired
	private DTSService dtsService;
	
	
	/**
	 * 
	 * @author  Haritha
	 * @version 1.0
	 * @since   2020-01-16 
	 * 
	 **/
	
	@GetMapping("/getDataForDTSProcessing")
	public StatusResponse getDataForProcessing() {
		StatusResponse response=new StatusResponse();
		
		try {
			response=dtsService.getpreProcessingData();
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(501, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionresponse);
		}
		return response;
		
	}
	
	
	/**
	 * 
	 * @author  Haritha
	 * @version 1.0
	 * @since   2020-01-16 
	 * 
	 **/
	@PostMapping("/addNewDTSData")
	public StatusResponse addNewDTSData(@RequestBody DtsRequestBody requestBody) {
		StatusResponse response=new StatusResponse();
		
		try {
			response=dtsService.addNewDTSData(requestBody);
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(501, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, exceptionresponse);
		}
		return response;
		
	}
	
}
