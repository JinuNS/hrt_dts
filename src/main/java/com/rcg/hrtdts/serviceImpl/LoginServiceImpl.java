package com.rcg.hrtdts.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.dto.LoginResponseDto;
import com.rcg.hrtdts.model.PageRule;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.model.UserModel;
import com.rcg.hrtdts.repository.PageRuleRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.LoginService;
import com.rcg.hrtdts.utility.Constants;

/**
 * 
 * @author charly
 * @version 1.0
 * @since 2020-01-16
 * 
 **/
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	PageRuleRepository pageRuleRepository;

	@Override
	public StatusResponse getLoginCredentials(LoginDto requestDto) throws Exception {
		StatusResponse result = new StatusResponse();
		UserModel user = null;
		List<PageRule> pageRule = null;
		LoginResponseDto loginResponseDto = null;
		if (requestDto != null) {
			if (requestDto.getUsername() != null && !requestDto.getUsername().isEmpty()) {
				user = userRepository.findByuserName(requestDto.getUsername());
				if (user != null && user.getRole() != null && user.getRole().getRoleId() != null) {
					pageRule = pageRuleRepository.findByroleId(user.getRole().getRoleId());
				}
			}
			if (user != null && pageRule != null) {
				loginResponseDto = createLoginResponse(user, pageRule);
			}
			if (loginResponseDto != null)
				result = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, loginResponseDto);
			else
				result = new StatusResponse(Constants.FAILURE, HttpStatus.OK, "");

		}
		return result;
	}

	private LoginResponseDto createLoginResponse(UserModel user, List<PageRule> pageRule) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		loginResponseDto.seteId(user.geteId());
		loginResponseDto.setUserId(user.getUserId());
		loginResponseDto.setEmail(user.getEmail());
		loginResponseDto.setRole(user.getRole());
		loginResponseDto.setUserName(user.getUserName());
		loginResponseDto.setPageRule(pageRule);

		return loginResponseDto;
	}

}
