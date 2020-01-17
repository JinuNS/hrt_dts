package com.rcg.hrtdts.dto;

import java.util.Date;
import java.util.List;

public class ProjectDto {
	
	private Long  approverLevel1;
	private Long  approverLevel2;
	private Long  clientId;
	private Long  sessionId;
	private String  clientPointOfContact;
	private Long  contractType;
	private Date endDate;
	private Integer estimatedHours;
	private Integer isBillable;
	private Integer isPOC;
	private Long parentProjectId;
	private Integer projectCategory;
	private String projectCode;
	private String projectDetails;
	private String projectName;
	private List<Long> projectRegion;
	private Integer projectStatus;
	private Integer projectTier;
	private Integer projectType;
	private Date releasingDate;
	private Date startDate;
	private Integer workflowType;

	public Long getApproverLevel1() {
		return approverLevel1;
	}
	public void setApproverLevel1(Long approverLevel1) {
		this.approverLevel1 = approverLevel1;
	}
	public Long getApproverLevel2() {
		return approverLevel2;
	}
	public void setApproverLevel2(Long approverLevel2) {
		this.approverLevel2 = approverLevel2;
	}
	public Long getClientId() {
		return clientId;
	}
	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}
	public Long getSessionId() {
		return sessionId;
	}
	public void setSessionId(Long sessionId) {
		this.sessionId = sessionId;
	}
	public String getClientPointOfContact() {
		return clientPointOfContact;
	}
	public void setClientPointOfContact(String clientPointOfContact) {
		this.clientPointOfContact = clientPointOfContact;
	}
	public Long getContractType() {
		return contractType;
	}
	public void setContractType(Long contractType) {
		this.contractType = contractType;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getEstimatedHours() {
		return estimatedHours;
	}
	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}
	public Integer getIsBillable() {
		return isBillable;
	}
	public void setIsBillable(Integer isBillable) {
		this.isBillable = isBillable;
	}
	public Integer getIsPOC() {
		return isPOC;
	}
	public void setIsPOC(Integer isPOC) {
		this.isPOC = isPOC;
	}
	public Long getParentProjectId() {
		return parentProjectId;
	}
	public void setParentProjectId(Long parentProjectId) {
		this.parentProjectId = parentProjectId;
	}
	public Integer getProjectCategory() {
		return projectCategory;
	}
	public void setProjectCategory(Integer projectCategory) {
		this.projectCategory = projectCategory;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectDetails() {
		return projectDetails;
	}
	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	
	public List<Long> getProjectRegion() {
		return projectRegion;
	}
	public void setProjectRegion(List<Long> projectRegion) {
		this.projectRegion = projectRegion;
	}
	public Integer getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}
	public Integer getProjectTier() {
		return projectTier;
	}
	public void setProjectTier(Integer projectTier) {
		this.projectTier = projectTier;
	}
	public Integer getProjectType() {
		return projectType;
	}
	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}
	public Date getReleasingDate() {
		return releasingDate;
	}
	public void setReleasingDate(Date releasingDate) {
		this.releasingDate = releasingDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Integer getWorkflowType() {
		return workflowType;
	}
	public void setWorkflowType(Integer workflowType) {
		this.workflowType = workflowType;
	}

}
