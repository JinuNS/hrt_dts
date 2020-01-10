package com.rcg.hrtdts.serviceImpl;

import org.springframework.stereotype.Service;
import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.service.HrtDtsService;

@Service
public class HrtDtsServiceImpl implements HrtDtsService {

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StatusResponse getUserInfo(RequestDto requestDto) throws Exception{
		StatusResponse response = new StatusResponse("success", 200, requestDto);
		throw new Exception("Exception happend..");
		//return response;
	}
	
}
