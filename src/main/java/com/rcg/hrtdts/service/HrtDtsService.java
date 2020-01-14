/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-10 
*/

package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
import com.rcg.hrtdts.exception.PMSException;
import com.rcg.hrtdts.exception.PMSNotFoundException;
import com.rcg.hrtdts.model.StatusResponse;


public interface HrtDtsService {

	@SuppressWarnings("rawtypes")
	public StatusResponse getUserInfo(RequestDto requestDto) throws PMSException,PMSNotFoundException;

	@SuppressWarnings("rawtypes")
	public StatusResponse saveUserInfo(UserDto userDto) throws PMSException,PMSNotFoundException;
}
