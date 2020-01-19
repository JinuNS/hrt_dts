package com.rcg.hrtdts.dto;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-15
 * 
 **/
public class UserSkillResponseDto {

	private Long skillId;
	private String skill;
	private Integer level;
	private Double experiance;
	private String comment;

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

	public Double getExperiance() {
		return experiance;
	}

	public void setExperiance(Double experiance) {
		this.experiance = experiance;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	
}
