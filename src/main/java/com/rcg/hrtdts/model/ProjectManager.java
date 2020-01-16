package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProjectManager {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long projectManagerId;
	
	private String projectManager;

	public Long getProjectManagerId() {
		return projectManagerId;
	}

	public void setProjectManagerId(Long projectManagerId) {
		this.projectManagerId = projectManagerId;
	}

	public String getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(String projectManager) {
		this.projectManager = projectManager;
	}
	
}
