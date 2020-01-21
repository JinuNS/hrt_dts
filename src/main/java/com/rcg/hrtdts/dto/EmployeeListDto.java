package com.rcg.hrtdts.dto;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class EmployeeListDto {

	private Long eId;
	private String firstName;
	private String lastName;
	private String userName;
	private String jobType;
	private String department;
	private String cppLevel;
	private Date hireDate;
	private String status;
	private String consultantType;

	public EmployeeListDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public EmployeeListDto(Long eId,String firstName, String lastName, String userName, String jobType, String department,
			String cppLevel, Date hireDate, String status, String consultantType) {
		super();
		this.eId = eId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userName = userName;
		this.jobType = jobType;
		this.department = department;
		this.cppLevel = cppLevel;
		this.hireDate = hireDate;
		this.status = status;
		this.consultantType = consultantType;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getCppLevel() {
		return cppLevel;
	}

	public void setCppLevel(String cppLevel) {
		this.cppLevel = cppLevel;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getConsultantType() {
		return consultantType;
	}

	public void setConsultantType(String consultantType) {
		this.consultantType = consultantType;
	}

	
}
