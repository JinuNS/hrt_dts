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

import com.rcg.hrtdts.dto.DtsRequestBodyDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.DTSService;
import com.rcg.hrtdts.utility.Constants;

@RestController
@RequestMapping(value = "/dts")
public class DTSController {

	@Autowired
	private DTSService dtsService;

	/**
	 * 
	 * @author Haritha
	 * @version 1.0
	 * @since 2020-01-16
	 * 
	 **/

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/listPreData")
	public StatusResponse getDataForProcessing() {
		StatusResponse response = new StatusResponse();

		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(), dtsService.getpreProcessingData());
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionresponse);
		}
		return response;

	}

	/**
	 * 
	 * @author Haritha
	 * @version 1.0
	 * @since 2020-01-16
	 * 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/create")
	public StatusResponse addNewDTSData(@RequestBody DtsRequestBodyDto requestBody) {
		StatusResponse response = new StatusResponse();

		try {
			dtsService.addNewDTSData(requestBody);
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(), "Insertion completed");
		} catch (HRTDTSException e) {

			throw new HRTDTSException(e.getErrorCode(), e.getErrorMessage());
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionresponse);
		}
		return response;

	}

	/**
	 * 
	 * @author Haritha
	 * @version 1.0
	 * @since 2020-01-16
	 * 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/list")
	public StatusResponse getDTSData() {
		StatusResponse response = new StatusResponse();

		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(), dtsService.getDTSData());
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionresponse);
		}
		return response;

	}

	/**
	 * 
	 * @author Haritha
	 * @version 1.0
	 * @since 2020-01-18
	 * 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/projectlist/{clientId}")
	public StatusResponse getAllClientProjects(@PathVariable("clientId") Long clientId,
			@RequestBody String requestdata) {
		StatusResponse response = new StatusResponse();

		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					dtsService.getAllClientProjects(clientId));
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionresponse);
		}
		return response;

	}

	/**
	 * 
	 * @author Haritha
	 * @version 1.0
	 * @since 2020-01-18
	 * 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/edit/{dtsId}")
	public StatusResponse getDTSInformation(@PathVariable("dtsId") Long dtsId, @RequestBody String requestdata) {
		StatusResponse response = new StatusResponse();

		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					dtsService.getDTSInformation(dtsId));
		} catch (Exception e) {
			e.printStackTrace();
			ExceptionResponse exceptionresponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionresponse);
		}
		return response;

	}
}
