package com.rcg.hrtdts.service;

import java.util.List;

import com.rcg.hrtdts.dto.EmployeeListDto;
import com.rcg.hrtdts.dto.EmployeeRequestDto;
import com.rcg.hrtdts.dto.EmployeeResponseDto;
import com.rcg.hrtdts.dto.PreDataDto;
import com.rcg.hrtdts.exception.HRTDTSException;
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

	String saveEmployeeInfo(EmployeeRequestDto requestDto) throws HRTDTSException,Exception;

	PreDataDto getSkillsAndReferrals() throws Exception;

	EmployeeResponseDto getUserHrtInfo(long id) throws Exception;

	EmployeeModel getUserDetailsById(Long asLong);

	List<EmployeeListDto> getEmployeeList() throws Exception;


//	StatusResponse updateEmployeeInfo(EmployeeRequestDto requestDto) throws Exception;

}

