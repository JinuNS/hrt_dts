package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
@Entity
public class EmployeeTechnologyModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private EmployeeModel userHrtModel;
	@ManyToOne
	private TechnologyModel skills;
	private Integer skillLevel;
	private Double experience;
	private String comment;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EmployeeModel getUserHrtModel() {
		return userHrtModel;
	}

	public void setUserHrtModel(EmployeeModel userHrtModel) {
		this.userHrtModel = userHrtModel;
	}

	public TechnologyModel getSkills() {
		return skills;
	}

	public void setSkills(TechnologyModel skills) {
		this.skills = skills;
	}

	public Integer getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(Integer skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

}
