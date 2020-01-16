package com.rcg.hrtdts.dto;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-15
 * 
 **/
public class UserSkillResponseDto {

	private String skill;
	private Integer level;

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
