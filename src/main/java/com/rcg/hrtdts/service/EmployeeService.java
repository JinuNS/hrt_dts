package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.EmployeeDto;
import com.rcg.hrtdts.model.StatusResponse;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeService {

	StatusResponse saveNewHrt(EmployeeDto requestDto) throws Exception;

	StatusResponse getSkillsAndReferrals() throws Exception;

	StatusResponse getUserHrtInfo(long id) throws Exception;

}

