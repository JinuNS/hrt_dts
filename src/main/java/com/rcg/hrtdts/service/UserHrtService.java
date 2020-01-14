package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.UserHrtDto;
import com.rcg.hrtdts.model.StatusResponse;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface UserHrtService {

	StatusResponse saveNewHrt(UserHrtDto requestDto) throws Exception;

	StatusResponse getSkillsAndReferrals() throws Exception;

}

