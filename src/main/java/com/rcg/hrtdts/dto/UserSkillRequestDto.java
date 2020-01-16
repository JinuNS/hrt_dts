package com.rcg.hrtdts.dto;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
public class UserSkillRequestDto {

	private Long skillId;
	private Integer level;

	public Long getSkillId() {
		return skillId;
	}

	public void setSkillId(Long skillId) {
		this.skillId = skillId;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

}
