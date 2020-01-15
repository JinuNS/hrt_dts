package com.rcg.hrtdts.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.model.StatusResponse;


/**
 * 
 * @author  Renjith
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
@RestController
@RequestMapping(value = { "/hrtdts" })
public class LoginController {
	
	
	@PostMapping(value = ("/login"))
	public StatusResponse getLoginCredentials(@RequestBody LoginDto requestDto){
		requestDto.setPwd("");
		StatusResponse response = new StatusResponse("success", 200, requestDto);
		return response;
	}

}
