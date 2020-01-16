package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
@Entity
public class SkillsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String skill;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

}
