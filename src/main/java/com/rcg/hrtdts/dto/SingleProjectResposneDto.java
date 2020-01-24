package com.rcg.hrtdts.dto;

import java.util.ArrayList;
import java.util.List;
import com.rcg.hrtdts.model.ContractModel;
public class SingleProjectResposneDto {
    private Long projectId;
    private Integer projectCategory,projectTier,workflowType;
    private String projectName, projectDetails;
    private Integer estimatedHours;
    private String startDate, endDate,releasingDate;
    private Integer isBillable;
    private String projectCode;
    private Integer projectType, isPOC, projectStatus;
    private String clientPointOfContact;
    private Long parentProjectId;
    private ClientResponseDto clientName;
    private ContractModel contractType;
    private ProjectUserSingleDto approverLevelOne;
    private ProjectUserSingleDto approverLevelTwo;
    private List projectRegion;
    private List resource;
    
    
    
    
    public ProjectUserSingleDto getApproverLevelTwo() {
        return approverLevelTwo;
    }
    public void setApproverLevelTwo(ProjectUserSingleDto approverLevelTwo) {
        this.approverLevelTwo = approverLevelTwo;
    }
    public ProjectUserSingleDto getApproverLevelOne() {
        return approverLevelOne;
    }
    public void setApproverLevelOne(ProjectUserSingleDto approverLevelOne) {
        this.approverLevelOne = approverLevelOne;
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
    public Long getParentProjectId() {
        return parentProjectId;
    }
    public void setParentProjectId(Long parentProjectId) {
        this.parentProjectId = parentProjectId;
    }
    public String getReleasingDate() {
        return releasingDate;
    }
    public void setReleasingDate(String releasingDate) {
        this.releasingDate = releasingDate;
    }
    public Integer getProjectTier() {
        return projectTier;
    }
    public void setProjectTier(Integer projectTier) {
        this.projectTier = projectTier;
    }
    public Integer getWorkflowType() {
        return workflowType;
    }
    public void setWorkflowType(Integer workflowType) {
        this.workflowType = workflowType;
    }
    public ClientResponseDto getClientName() {
        return clientName;
    }
    public void setClientName(ClientResponseDto clientName) {
        this.clientName = clientName;
    }
    public ContractModel getContractType() {
        return contractType;
    }
    public void setContractType(ContractModel contractType) {
        this.contractType = contractType;
    }
    public List getProjectRegion() {
        return projectRegion;
    }
    public void setProjectRegion(List projectRegion) {
        this.projectRegion = projectRegion;
    }
    public List getResource() {
        return resource;
    }
    public void setResource(List resource) {
        this.resource = resource;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
