package com.rcg.hrtdts.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
import com.rcg.hrtdts.exception.PMSException;
import com.rcg.hrtdts.exception.PMSNotFoundException;
import com.rcg.hrtdts.model.AdminDetails;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.model.UserDetails;
import com.rcg.hrtdts.repository.AdminRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.HrtDtsService;

@Service
public class HrtDtsServiceImpl implements HrtDtsService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AdminRepository adminRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public StatusResponse getUserInfo(RequestDto requestDto) throws Exception,PMSException,PMSNotFoundException{
		StatusResponse response = new StatusResponse("success", 200, requestDto);
		
		if(true)
			throw new PMSException();
		
		return response;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public StatusResponse saveUserInfo(UserDto userDto) throws Exception,PMSException,PMSNotFoundException{
		
		saveUser(userDto);
		saveAdmin(userDto);		
		StatusResponse response = new StatusResponse("success", 200, userDto);
		return response;
	}
	private void saveUser(UserDto userDto) throws Exception,PMSException,PMSNotFoundException{
		UserDetails userDetails = new UserDetails();
		userDetails.setName(userDto.getName());
		userDetails.setAddress(userDto.getAddress());
		userRepository.save(userDetails);
		
		
	}
	private void saveAdmin(UserDto userDto) throws Exception,PMSException,PMSNotFoundException{
		
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setName(userDto.getName());
		adminDetails.setAddress(userDto.getAddress());
		adminRepository.save(adminDetails);
		
		if(true)
			throw new PMSNotFoundException();	
	}
}
