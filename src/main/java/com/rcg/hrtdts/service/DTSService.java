package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.DtsRequestBody;
import com.rcg.hrtdts.model.StatusResponse;

public interface DTSService {

	StatusResponse getpreProcessingData() throws Exception;

	StatusResponse addNewDTSData(DtsRequestBody requestBody) throws Exception;

	StatusResponse getDTSData() throws Exception;

	StatusResponse getAllClientProjects(Long clientId);

	StatusResponse getDTSInformation(Long dtsId);

}
