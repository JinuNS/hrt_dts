package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class ProjectRegion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long projectRegionId;
	
	@ManyToOne
	private ProjectModel projectId;
	
	@ManyToOne
	private RegionModel regionId;

	public long getProjectRegionId() {
		return projectRegionId;
	}

	public void setProjectRegionId(long projectRegionId) {
		this.projectRegionId = projectRegionId;
	}

	public ProjectModel getProjectId() {
		return projectId;
	}

	public void setProjectId(ProjectModel projectId) {
		this.projectId = projectId;
	}

	public RegionModel getRegionId() {
		return regionId;
	}

	public void setRegionId(RegionModel regionId) {
		this.regionId = regionId;
	}


	
}
