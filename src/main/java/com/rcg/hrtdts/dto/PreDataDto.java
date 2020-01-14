package com.rcg.hrtdts.dto;

import java.util.List;

import com.rcg.hrtdts.model.ReferralsModel;
import com.rcg.hrtdts.model.SkillsModel;

public class PreDataDto {

	private List<SkillsModel> skills;
	private List<ReferralsModel> referrals;

	public List<SkillsModel> getSkills() {
		return skills;
	}

	public void setSkills(List<SkillsModel> skills) {
		this.skills = skills;
	}

	public List<ReferralsModel> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<ReferralsModel> referrals) {
		this.referrals = referrals;
	}
}
