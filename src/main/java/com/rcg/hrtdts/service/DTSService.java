package com.rcg.hrtdts.service;

import java.util.List;

import com.rcg.hrtdts.dto.DtsRequestBodyDto;
import com.rcg.hrtdts.dto.GetDtsDataResponseDto;
import com.rcg.hrtdts.dto.PreProcessingDataResponseDto;
import com.rcg.hrtdts.dto.ProjectResponseDto;
import com.rcg.hrtdts.dto.ViewDtsInfoResponseDto;
import com.rcg.hrtdts.exception.HRTDTSException;

public interface DTSService {

	PreProcessingDataResponseDto getpreProcessingData() throws Exception;

	void addNewDTSData(DtsRequestBodyDto requestBody) throws Exception, HRTDTSException;

	List<ViewDtsInfoResponseDto> getDTSData() throws Exception;

	List<ProjectResponseDto> getAllClientProjects(Long clientId);

	GetDtsDataResponseDto getDTSInformation(Long dtsId);

}
