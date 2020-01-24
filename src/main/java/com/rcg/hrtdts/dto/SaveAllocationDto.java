package com.rcg.hrtdts.dto;

import java.util.Date;

public class SaveAllocationDto {
private Date startDate;
private Date endDate;
private Double allocatedPercentage;
private Long projectId;
private Long userId;
private Boolean isBillable;
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
public Double getAllocatedPercentage() {
	return allocatedPercentage;
}
public void setAllocatedPercentage(Double allocatedPercentage) {
	this.allocatedPercentage = allocatedPercentage;
}
public Long getProjectId() {
	return projectId;
}
public void setProjectId(Long projectId) {
	this.projectId = projectId;
}
public Long getUserId() {
	return userId;
}
public void setUserId(Long userId) {
	this.userId = userId;
}
public Boolean getIsBillable() {
	return isBillable;
}
public void setIsBillable(Boolean isBillable) {
	this.isBillable = isBillable;
}

}
