package com.rcg.hrtdts.serviceImpl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.LoginService;
import com.rcg.hrtdts.utility.Constants;
/**
 * 
 * @author charly
 * @version 1.0
 * @since 2020-01-16
 * 
 **/
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Override
	public StatusResponse getLoginCredentials(LoginDto requestDto) throws Exception {
		
		
		
		
		
		StatusResponse result = new StatusResponse(Constants.SUCCESS,Constants.SUCCESS_CODE,null);
		return result;
	}

}
