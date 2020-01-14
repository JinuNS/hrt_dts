package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.UserHrtDto;
import com.rcg.hrtdts.model.StatusResponse;

public interface UserHrtService {

	StatusResponse saveNewHrt(UserHrtDto requestDto) throws Exception;

	StatusResponse getSkillsAndReferrals() throws Exception;

}

