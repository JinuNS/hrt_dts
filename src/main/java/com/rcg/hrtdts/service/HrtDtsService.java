package com.rcg.hrtdts.service;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.model.StatusResponse;


public interface HrtDtsService {

	@SuppressWarnings("rawtypes")
	public StatusResponse getUserInfo(RequestDto requestDto) throws Exception;
}
