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


public interface HrtDtsService {

	public String getUserInfo(RequestDto requestDto) throws PMSException,PMSNotFoundException;

	public UserDto saveUserInfo(UserDto userDto) throws PMSException,PMSNotFoundException;
}
