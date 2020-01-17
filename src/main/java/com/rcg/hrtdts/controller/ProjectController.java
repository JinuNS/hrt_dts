/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/
package com.rcg.hrtdts.controller;

import java.text.ParseException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.exception.HRTDTSDateFormatException;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.exception.HRTDTSNotFoundException;
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
			
			
			/*if(projectDetails.get("status").equals(Constants.SUCCESS))
				response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, projectDetails);
			else
				response = new StatusResponse(Constants.FAILURE, HttpStatus.INTERNAL_SERVER_ERROR, projectDetails);*/
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

	
}
