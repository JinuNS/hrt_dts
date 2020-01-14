package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
@Entity
public class UserHrtSkillsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@ManyToOne
	private UserHrtModel userHrtModel;
	@ManyToOne
	private SkillsModel skills;
	private int skill_level;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserHrtModel getUserHrtModel() {
		return userHrtModel;
	}

	public void setUserHrtModel(UserHrtModel userHrtModel) {
		this.userHrtModel = userHrtModel;
	}

	public SkillsModel getSkills() {
		return skills;
	}

	public void setSkills(SkillsModel skills) {
		this.skills = skills;
	}

	public int getSkill_level() {
		return skill_level;
	}

	public void setSkill_level(int skill_level) {
		this.skill_level = skill_level;
	}

}
