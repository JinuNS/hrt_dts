package com.rcg.hrtdts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class UserModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long userId;

	@Column(unique = true)
	private long eId;
	
	private String userName, password,email;
	
	@ManyToOne
	private RoleModel role;

	
	
	
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
		this.eId = eId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	
	
	

}
