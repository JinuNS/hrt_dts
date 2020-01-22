package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resources {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long resourceId;

	@ManyToOne
	private DepartmentModel department;
	private int resourceCount;

	@ManyToOne
	private ProjectModel project;

	public ProjectModel getProject() {
		return project;
	}

	public void setProject(ProjectModel project) {
		this.project = project;
	}

	public Resources() {

	}

	public Resources(long resourceId, int resourceCount) {
		super();
		this.resourceId = resourceId;
		this.resourceCount = resourceCount;
	}

	public DepartmentModel getDepartment() {
		return department;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}

	public int getresourceCount() {
		return resourceCount;
	}

	public void setresourceCount(int resourceCount) {
		this.resourceCount = resourceCount;
	}

}
