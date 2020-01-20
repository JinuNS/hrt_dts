package com.rcg.hrtdts.dto;

import java.util.Date;

public class ViewDtsInfoResponseDto {

	private Long dtsId;
	private Long dtsNo;
	private String status;
	private String startDate,endDate;
	private Long projectName;
	private Long employeeId;
	private String employeeName;
	private String rcgMail;
	private String jobType;
	private String cppLevel;
	
	
	public String getCppLevel() {
		return cppLevel;
	}
	public void setCppLevel(String cppLevel) {
		this.cppLevel = cppLevel;
	}
	
	public Long getDtsId() {
		return dtsId;
	}
	public void setDtsId(Long dtsId) {
		this.dtsId = dtsId;
	}
	public Long getDtsNo() {
		return dtsNo;
	}
	public void setDtsNo(Long dtsNo) {
		this.dtsNo = dtsNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public Long getProjectName() {
		return projectName;
	}
	public void setProjectName(Long projectName) {
		this.projectName = projectName;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getRcgMail() {
		return rcgMail;
	}
	public void setRcgMail(String rcgMail) {
		this.rcgMail = rcgMail;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	
	
	
}
