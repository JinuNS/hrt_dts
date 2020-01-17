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
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, projectDetails);
		}
		catch (HRTDTSNotFoundException e) {
			throw new HRTDTSNotFoundException(e.getErrorMessage());
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException(e.getErrorMessage());
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException(e.getMessage());
		}
		return response;
	}
	
	@GetMapping(value = { "/listOfprojects" })
	public StatusResponse projectListDataForAdmin(@RequestBody ProjectHrtDto projectHrtDto) throws Exception {
		StatusResponse status = new StatusResponse();

		try {
			status = projectservice.projectListDataForAdmin(projectHrtDto);
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
		JSONObject projectDetails = new JSONObject();
		try {		
			projectDetails = projectservice.updateProject(projectDto);
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, "Project updated successfully");
		}
		catch (HRTDTSException e) {
			throw new HRTDTSException("Updation Failed");
		} catch (ParseException e) {
			throw new HRTDTSDateFormatException("Updation Failed due to invalid date format");
		}
		return response;
	}
	
}
