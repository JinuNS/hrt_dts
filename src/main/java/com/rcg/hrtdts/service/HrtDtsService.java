package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
import com.rcg.hrtdts.model.StatusResponse;


public interface HrtDtsService {

	@SuppressWarnings("rawtypes")
	public StatusResponse getUserInfo(RequestDto requestDto) throws Exception;

	@SuppressWarnings("rawtypes")
	public StatusResponse saveUserInfo(UserDto userDto) throws Exception;
}
