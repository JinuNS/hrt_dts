package com.rcg.hrtdts.dto;

import java.util.List;

import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.ReferralsModel;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.TechnologyModel;
import com.rcg.hrtdts.model.TerminationTypeModel;
import com.rcg.hrtdts.model.TimeZoneModel;

/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/

public class PreDataDto {

	private List<TechnologyModel> skills;
	private List<ReferralsModel> referrals;
	private List<RegionModel> region;
	private List<DepartmentModel> department;
	private List<TimeZoneModel> timeZone;
	private List<TerminationTypeModel> terminationType;
	private List<EmployeeContractorsModel> employeeContractors;

	public List<TechnologyModel> getSkills() {
		return skills;
	}

	public void setSkills(List<TechnologyModel> skills) {
		this.skills = skills;
	}

	public List<ReferralsModel> getReferrals() {
		return referrals;
	}

	public void setReferrals(List<ReferralsModel> referrals) {
		this.referrals = referrals;
	}

	public List<RegionModel> getRegion() {
		return region;
	}

	public void setRegion(List<RegionModel> region) {
		this.region = region;
	}

	public List<DepartmentModel> getDepartment() {
		return department;
	}

	public void setDepartment(List<DepartmentModel> department) {
		this.department = department;
	}

	public List<TimeZoneModel> getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(List<TimeZoneModel> timeZone) {
		this.timeZone = timeZone;
	}

	public List<TerminationTypeModel> getTerminationType() {
		return terminationType;
	}

	public void setTerminationType(List<TerminationTypeModel> terminationType) {
		this.terminationType = terminationType;
	}

	public List<EmployeeContractorsModel> getEmployeeContractors() {
		return employeeContractors;
	}

	public void setEmployeeContractors(List<EmployeeContractorsModel> employeeContractors) {
		this.employeeContractors = employeeContractors;
	}
	
	
}
