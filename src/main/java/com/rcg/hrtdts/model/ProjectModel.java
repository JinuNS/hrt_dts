package com.rcg.hrtdts.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class ProjectModel {

	@Id
	@Column(name = "projectId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Cascade(CascadeType.ALL)
	private Long projectId;
	private Integer projectCategory;
	private String projectName, projectDetails;
	private Integer estimatedHours;
	private Date startDate, endDate, releasingDate;
	private Integer isBillable;
	private String projectCode;
	private Integer projectType, isPOC, projectStatus;
	private String clientPointOfContact;
	private long parentProjectId;
	private Integer projectTier; 
	private String projectRefId;
	private Integer workflowType;
	
	@ManyToOne
	private ClientModel clientName;

	@ManyToOne
	private EmployeeModel projectOwner;

	@ManyToOne
	private ContractModel contract;

	@ManyToOne
	private EmployeeModel onsiteLead;

	public ProjectModel(long projectId, String projectName, String projectDetails, int estimatedHours, Date startDate,
			Date endDate, int isBillable, String projectCode, int projectType, EmployeeModel projectOwner,
			long parentProjectId, ContractModel contract,Integer workflowType) {
		super();
		this.projectId = projectId;
		this.parentProjectId = parentProjectId;
		this.projectName = projectName;
		this.projectDetails = projectDetails;
		this.estimatedHours = estimatedHours;
		this.startDate = startDate;
		this.endDate = endDate;
		this.isBillable = isBillable;
		this.projectCode = projectCode;
		this.projectType = projectType;
		this.projectOwner = projectOwner;
		this.contract = contract;
		this.workflowType=workflowType;
	}

	public ProjectModel() {
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public Integer getProjectCategory() {
		return projectCategory;
	}

	public void setProjectCategory(Integer projectCategory) {
		this.projectCategory = projectCategory;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public Integer getEstimatedHours() {
		return estimatedHours;
	}

	public void setEstimatedHours(Integer estimatedHours) {
		this.estimatedHours = estimatedHours;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getReleasingDate() {
		return releasingDate;
	}

	public void setReleasingDate(Date releasingDate) {
		this.releasingDate = releasingDate;
	}

	public Integer getIsBillable() {
		return isBillable;
	}

	public void setIsBillable(Integer isBillable) {
		this.isBillable = isBillable;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public Integer getProjectType() {
		return projectType;
	}

	public void setProjectType(Integer projectType) {
		this.projectType = projectType;
	}

	public Integer getIsPOC() {
		return isPOC;
	}

	public void setIsPOC(Integer isPOC) {
		this.isPOC = isPOC;
	}

	public Integer getProjectStatus() {
		return projectStatus;
	}

	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}

	public String getClientPointOfContact() {
		return clientPointOfContact;
	}

	public void setClientPointOfContact(String clientPointOfContact) {
		this.clientPointOfContact = clientPointOfContact;
	}

	public long getParentProjectId() {
		return parentProjectId;
	}

	public void setParentProjectId(long parentProjectId) {
		this.parentProjectId = parentProjectId;
	}

	public Integer getProjectTier() {
		return projectTier;
	}

	public void setProjectTier(Integer projectTier) {
		this.projectTier = projectTier;
	}

	public Integer getWokflowType() {
		return workflowType;
	}

	public void setWokflowType(Integer workflowType) {
		this.workflowType = workflowType;
	}

	public ClientModel getClientName() {
		return clientName;
	}

	public void setClientName(ClientModel clientName) {
		this.clientName = clientName;
	}

	public EmployeeModel getProjectOwner() {
		return projectOwner;
	}

	public void setProjectOwner(EmployeeModel projectOwner) {
		this.projectOwner = projectOwner;
	}

	public ContractModel getContract() {
		return contract;
	}

	public void setContract(ContractModel contract) {
		this.contract = contract;
	}

	public String getProjectRefId() {
		return projectRefId;
	}

	public void setProjectRefId(String projectRefId) {
		this.projectRefId = projectRefId;
	}

	public EmployeeModel getOnsiteLead() {
		return onsiteLead;
	}

	public void setOnsiteLead(EmployeeModel onsiteLead) {
		this.onsiteLead = onsiteLead;
	}





}
