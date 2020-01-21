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
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.DtsRequestBody;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.DTSRepository;
import com.rcg.hrtdts.service.DTSService;
import com.rcg.hrtdts.utility.Constants;

@RestController
@RequestMapping(value="/dts")
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
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionresponse);
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
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionresponse);
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
	@GetMapping("/getDTSData")
	public StatusResponse getDTSData() {
		StatusResponse response=new StatusResponse();
		
		try {
			response=dtsService.getDTSData();
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionresponse);
		}
		return response;
		
	}
	
	/**
	 * 
	 * @author  Haritha
	 * @version 1.0
	 * @since   2020-01-18 
	 * 
	 **/
	@PutMapping("/getAllClientProjects/{clientId}")
	public StatusResponse getAllClientProjects(@PathVariable("clientId") Long clientId,@RequestBody String requestdata) {
		StatusResponse response=new StatusResponse();
		
		try {
			response=dtsService.getAllClientProjects(clientId);
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionresponse);
		}
		return response;
		
	}
	
	/**
	 * 
	 * @author  Haritha
	 * @version 1.0
	 * @since   2020-01-18 
	 * 
	 **/
	@PutMapping("/getDTSInformation/{dtsId}")
	public StatusResponse getDTSInformation(@PathVariable("dtsId") Long dtsId,@RequestBody String requestdata) {
		StatusResponse response=new StatusResponse();
		
		try {
			response=dtsService.getDTSInformation(dtsId);
		}catch(Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date()); 
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionresponse);
		}
		return response;
		
	}
}
