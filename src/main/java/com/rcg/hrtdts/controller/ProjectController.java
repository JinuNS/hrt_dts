/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/
package com.rcg.hrtdts.controller;

import java.text.ParseException;
import java.util.Date;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.exception.HRTDTSDateFormatException;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.exception.HRTDTSNotFoundException;
import com.rcg.hrtdts.model.ExceptionResponse;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.ProjectService;
import com.rcg.hrtdts.utility.Constants;

@RestController
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	private ProjectService projectservice;

	
	/**
	 * To create new project
	 * @author  Jinu Shaji
	 * @version 1.0
	 * @since   2020-01-16 
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping("/create")
	public StatusResponse createNewProject(@RequestBody ProjectDto projectDto) {

		StatusResponse response = new StatusResponse();
		JSONObject projectDetails = new JSONObject();
		try {		
			projectDetails = projectservice.createNewProject(projectDto);
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(), projectDetails);
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException(e.getMessage());
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionResponse);
		}
		return response;
	}
	
	/**
	 * To edit project
	 * @author  Jinu Shaji
	 * @version 1.0
	 * @since   2020-01-17
	 **/
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PutMapping("/edit")
	public StatusResponse updateProject(@RequestBody ProjectDto projectDto) {
		StatusResponse response = new StatusResponse();
		try {		
			projectservice.updateProject(projectDto);
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(), "Project updated successfully");
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException("Updation Failed");
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException("Updation Failed due to invalid date format");
		} catch (Exception e) {
			ExceptionResponse exceptionResponse = new ExceptionResponse(500, e.getMessage(), new Date());
			response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR.value(), exceptionResponse);
		}
		return response;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@GetMapping("/getSingleProject/{projectId}")
	public StatusResponse getSingleProject(@PathVariable("projectId") Long projectId) throws ParseException {
		StatusResponse response = new StatusResponse();
		try {

			response = projectservice.getSingleProject(projectId);
		} catch (HRTDTSException e) {
			throw new HRTDTSException("Updation Failed");
		}
		return response;
	}
	
	@GetMapping(value = { "/listOfProjects" })
	public StatusResponse projectListDataForAdmin() throws Exception {
		StatusResponse status = new StatusResponse();

		try {
			status = projectservice.projectListDataForAdmin(new ProjectDto());
		} catch (HRTDTSNotFoundException e) {
			throw new HRTDTSNotFoundException(e.getErrorMessage());
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException(e.getMessage());
		}
		return status;
	}
	
	@PostMapping(value = { "/viewAllProjects" })
	public StatusResponse viewAllProjects(@RequestBody ProjectDto projectHrtDto) throws Exception {
		StatusResponse status = new StatusResponse();

		try {
			status = projectservice.viewAllProjects(projectHrtDto);
		} catch (HRTDTSNotFoundException e) {
			throw new HRTDTSNotFoundException(e.getErrorMessage());
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		}
		return status;
	}


	
}