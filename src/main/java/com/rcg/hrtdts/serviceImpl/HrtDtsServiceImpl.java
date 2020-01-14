package com.rcg.hrtdts.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcg.hrtdts.dto.RequestDto;
import com.rcg.hrtdts.dto.UserDto;
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
	public StatusResponse getUserInfo(RequestDto requestDto) throws Exception{
		StatusResponse response = new StatusResponse("success", 200, requestDto);
		return response;
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Transactional
	public StatusResponse saveUserInfo(UserDto userDto) throws Exception{
		
		saveUser(userDto);
		saveAdmin(userDto);		
		StatusResponse response = new StatusResponse("success", 200, userDto);
		return response;
	}
	private void saveUser(UserDto userDto) {
		UserDetails userDetails = new UserDetails();
		userDetails.setName(userDto.getName());
		userDetails.setAddress(userDto.getAddress());
		userRepository.save(userDetails);
	}
	private void saveAdmin(UserDto userDto) throws Exception {
		AdminDetails adminDetails = new AdminDetails();
		adminDetails.setName(userDto.getName());
		adminDetails.setAddress(userDto.getAddress());
		adminRepository.save(adminDetails);
	}
}
