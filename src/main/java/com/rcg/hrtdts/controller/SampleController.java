/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
import com.rcg.hrtdts.exception.PMSException;
import com.rcg.hrtdts.exception.PMSNotFoundException;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.HrtDtsService;
import com.rcg.hrtdts.utility.Constants;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = { "/hrtdts" })
public class SampleController {

	@Autowired
	HrtDtsService hrtDtsService;

	/**
	 * To get the user information
	 * 
	 * @author Jinu Shaji
	 * @version 1.0
	 * @since 2020-01-10
	 **/

	@ApiOperation(value = "View user information")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/user-information"))
	public StatusResponse getUserInformation(@RequestBody RequestDto requestDto) {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					hrtDtsService.getUserInfo(requestDto));
		} catch (PMSNotFoundException e) {
			throw new PMSException("PMSNotFoundException thrown from getUserInformation method");
		} catch (PMSException e) {
			throw new PMSException("PMSException thrown from getUserInformation method");
		}
		return response;
	}

	/**
	 * To save user information
	 * 
	 * @author Jinu Shaji
	 * @version 1.0
	 * @since 2020-01-13
	 **/
	@ApiOperation(value = "saveUserInformation")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully saved data"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@PostMapping(value = ("/save"))
	public StatusResponse saveUserInformation(@RequestBody UserDto userDto) {
		StatusResponse response = new StatusResponse();
		try {
			response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK.value(),
					hrtDtsService.saveUserInfo(userDto));
		} catch (PMSNotFoundException e) {
			throw new PMSNotFoundException("PMSNotFoundException thrown from saveUserInformation method");
		} catch (PMSException e) {
			throw new PMSException("PMSException thrown from saveUserInformation method");
		}
		return response;
	}
}
