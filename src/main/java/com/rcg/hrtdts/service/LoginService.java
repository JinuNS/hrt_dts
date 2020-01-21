package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.dto.LoginResponseDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.StatusResponse;

/**
 * 
 * @author  charly
 * @version 1.0
 * @since   2020-01-16 
 * 
 **/
public interface LoginService {
	
	LoginResponseDto getLoginCredentials(LoginDto requestDto) throws Exception,HRTDTSException;

}
