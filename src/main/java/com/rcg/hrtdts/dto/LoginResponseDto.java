package com.rcg.hrtdts.dto;

import java.util.List;

import javax.persistence.Column;

import com.rcg.hrtdts.model.PageRule;
import com.rcg.hrtdts.model.RoleModel;

public class LoginResponseDto {
	private Long userId;
	private Long eId;
	private String userName,email;
	private RoleModel role;
	private List<PageRule> pageRule;
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long geteId() {
		return eId;
	}
	public void seteId(Long eId) {
		this.eId = eId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public RoleModel getRole() {
		return role;
	}
	public void setRole(RoleModel role) {
		this.role = role;
	}
	public List<PageRule> getPageRule() {
		return pageRule;
	}
	public void setPageRule(List<PageRule> pageRule) {
		this.pageRule = pageRule;
	}
	
	

}
