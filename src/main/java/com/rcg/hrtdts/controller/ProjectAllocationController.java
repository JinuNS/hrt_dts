package com.rcg.hrtdts.controller;

import java.text.ParseException;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rcg.hrtdts.dto.PojectAllocationListDto;
import com.rcg.hrtdts.dto.ProjectAllocationUserListDto;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.SaveAllocationDto;
import com.rcg.hrtdts.exception.HRTDTSDateFormatException;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.exception.HRTDTSNotFoundException;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.ProjectAllocationService;
import com.rcg.hrtdts.utility.Constants;

@RestController
@RequestMapping("/projectAllocation")
public class ProjectAllocationController {

	@Autowired
	ProjectAllocationService projectAllocationService;

	/**
	 * To get list By Levels
	 * 
	 * @author Bala
	 * @version 1.0
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("listByLevels")
	public StatusResponse getProjectListByRegion(@RequestBody PojectAllocationListDto projectDto)
			throws HRTDTSNotFoundException, ParseException {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.getProjectlistByRegion(projectDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}

	/**
	 * To get users List By Region
	 * 
	 * @author Bala
	 * @version 1.0
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("usersListByRegion")
	public StatusResponse getAllocationListByRegion(@RequestBody ProjectAllocationUserListDto projectDto)
			throws HRTDTSNotFoundException, ParseException {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.getUserlistByRegion(projectDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException(e.getMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}
	
	/**
	 * To get users List By Region
	 * 
	 * @author Bala
	 * @version 1.0
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("usersByRegion")
	public StatusResponse getUsersListByRegion(@RequestBody ProjectDto projectDto)
			throws HRTDTSNotFoundException, ParseException {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.getUsersByRegion(projectDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}
	
	/**
	 * To get Resource List based on the projects
	 * 
	 * @author Bala
	 * @version 1.0
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("resourceListByProjects")
	public StatusResponse getResourceListByProjects(@RequestBody ProjectDto projectDto)
			throws HRTDTSNotFoundException, ParseException {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.getResourceListByProjects(projectDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}
	
	/**
	 * save project allocation
	 * 
	 * @author Bala
	 * @version 1.0
	 **/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/save")
	public StatusResponse saveAllocation(@RequestBody SaveAllocationDto saveAllocationDto)
	throws HRTDTSException{
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.saveAllocation(saveAllocationDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}
	
	/**
	 * edit project allocation
	 * 
	 * @author Bala
	 * @version 1.0
	 **/	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/edit")
	public StatusResponse editAllocation(@RequestBody SaveAllocationDto saveAllocationDto)
	throws HRTDTSException{
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					projectAllocationService.editAllocation(saveAllocationDto));
		} catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(),
					exceptionResponse);
		}
		return response;
	}
	
	

}
