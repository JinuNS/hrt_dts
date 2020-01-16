package com.rcg.hrtdts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.LoginService;


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
	
	@Autowired
	private LoginService loginService;
	
	
	@PostMapping(value = ("/login"))
	public StatusResponse getLoginCredentials(@RequestBody LoginDto requestDto){
		StatusResponse response = new StatusResponse();
		try {
			response = loginService.getLoginCredentials(requestDto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return response;
	}

}
