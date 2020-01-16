package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.model.StatusResponse;

/**
 * 
 * @author  charly
 * @version 1.0
 * @since   2020-01-16 
 * 
 **/
public interface LoginService {
	
	StatusResponse getLoginCredentials(LoginDto requestDto) throws Exception;

}
