package com.rcg.hrtdts.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rcg.hrtdts.dto.ChildPageRoleDto;
import com.rcg.hrtdts.dto.LoginDto;
import com.rcg.hrtdts.dto.LoginResponseDto;
import com.rcg.hrtdts.dto.ParentPageRuleDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.PageRule;
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
	public LoginResponseDto getLoginCredentials(LoginDto requestDto) throws Exception, HRTDTSException {
		UserModel user = null;
		List<PageRule> pageRule = null;
		LoginResponseDto loginResponseDto = null;

		if (requestDto != null) {
			if (requestDto.getUsername() != null && !requestDto.getUsername().isEmpty()
					&& requestDto.getUsername().trim().length() > 0) {
				user = userRepository.findByuserName(requestDto.getUsername());
				if (user != null) {
					if (!user.getIsActive()) {
						throw new HRTDTSException("User account has been deactivated");
					}
					if (user.getRole() != null && user.getRole().getRoleId() != null) {
						Long parentId = (long) 0;
						pageRule = pageRuleRepository.findByroleIdAndLevelId(user.getRole().getRoleId(), parentId);
					}
					loginResponseDto = createLoginResponse(user, pageRule);

				} else {
					throw new HRTDTSException(Constants.NO_DATA_FOUND_MESSAGE);
				}
			} else {
				throw new HRTDTSException("Invalid credentials");
			}
		} else {
			throw new HRTDTSException("Invalid login request");
		}

		if (loginResponseDto == null) {
			throw new HRTDTSException("Unable to create login response");
		}
		return loginResponseDto;
	}

	private LoginResponseDto createLoginResponse(UserModel user, List<PageRule> pageRule) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		if (user.getEmployee() != null)
			loginResponseDto.seteId(user.getEmployee().geteId());
		loginResponseDto.setUserId(user.getUserId());
		loginResponseDto.setEmail(user.getEmail());
		loginResponseDto.setRole(user.getRole());
		loginResponseDto.setUserName(user.getUserName());
		loginResponseDto.setPageRule(setPageRuleForParentAndChild(pageRule));
		loginResponseDto.setMessage("Valid user");
		return loginResponseDto;
	}

	private List<ParentPageRuleDto> setPageRuleForParentAndChild(List<PageRule> pageRuleList) {
		List<ParentPageRuleDto> parentPageRuleList = new ArrayList<ParentPageRuleDto>();
		;
		if (pageRuleList != null) {
			pageRuleList.forEach(parent -> {
				List<ChildPageRoleDto> childPageRuleList = new ArrayList<ChildPageRoleDto>();
				ParentPageRuleDto parentItem = new ParentPageRuleDto();
				List<PageRule> childsList = pageRuleRepository.findByparentIdOrderBySortAsc(parent.getPageId());
				childsList.forEach(child -> {
					ChildPageRoleDto childItem = new ChildPageRoleDto();
					childItem.setIcon(child.getIcon());
					childItem.setKey(child.getPageKey());
					childItem.setLabel(child.getLabel());
					childItem.setLevel(child.getLevelId());
					childItem.setMenu(child.getMenu());
					childItem.setPageId(child.getPageId());
					childItem.setPath(child.getPath());
					childPageRuleList.add(childItem);
				});
				parentItem.setChilds(childPageRuleList);
				parentItem.setIcon(parent.getIcon());
				parentItem.setKey(parent.getPageKey());
				parentItem.setLabel(parent.getLabel());
				parentItem.setLevel(parent.getLevelId());
				parentItem.setMenu(parent.getMenu());
				parentItem.setPageId(parent.getPageId());
				parentItem.setPath(parent.getPath());
				parentPageRuleList.add(parentItem);
			});
		}

		return parentPageRuleList;
	}

}
