package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.EmployeeRequestDto;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.StatusResponse;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeService {

	StatusResponse saveEmployeeInfo(EmployeeRequestDto requestDto) throws Exception;

	StatusResponse getSkillsAndReferrals() throws Exception;

	StatusResponse getUserHrtInfo(long id) throws Exception;

	EmployeeModel getUserDetailsById(Long asLong);

	StatusResponse getEmployeeList() throws Exception;


//	StatusResponse updateEmployeeInfo(EmployeeRequestDto requestDto) throws Exception;

}

