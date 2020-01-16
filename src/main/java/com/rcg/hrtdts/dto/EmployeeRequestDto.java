package com.rcg.hrtdts.dto;

import java.util.Date;
import java.util.List;

import javax.persistence.ManyToOne;

import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.TerminationTypeModel;
import com.rcg.hrtdts.model.TimeZoneModel;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
public class EmployeeRequestDto {

	private Long eId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long employeeNo;
	private String personalEmail;
	private Date hiredate;
	private String employeeType;
	private String division;
	private String assignmentBranch;
	private String typeofAction;
	private String streatAddress;
	private String apt;
	private String city;
	private String stateorCountry;
	private Long zip;
	private Long homePhone;
	private Long businessPhone;
	private Double hourlySalary;
	private Double overtimeSalary;
	private Double fixedRatePay;
	private Double dailyPayRate;
	private Double perdiemAllowence;
	private Boolean isContractReceived;
	private Boolean isHRRecievesContract;
	private String workCity;
	private String workState;
	private Integer hoursWorkedPerDay;
	private Date nextReviewDate;
	private String comments;
	private String companyName;
	private Boolean isCompanyIsAllianceMember;
	private String federalId;
	private Boolean isSubmissionGuidlineRecieved;
	private String rcgEmail;
	private Boolean isHiretoBeach;
	private Boolean isRehiredEmployee;
	private Long socialSecurityNumber;
	private String gender;
	private String jobType;
	private String maritalStatus;
	private String race;
	private Date dob;
	private String hireCodes;
	private String homeBranch;
	private String CPPCareerLevel;
	private List<UserSkillRequestDto> userSkills;
	private Long referralId;
	private Long RefLimit;
	private Date startDate;
	private Date endDate;
	private String notes;
	private Double ratePerDay;
	private Double ratePerHour;

	private Long department;

	private Long region;

	private Long timeZone;
	private Date terminationDate;
	private String bloodGroup;
	private String qualification;
	private String homeAddress;
	private String recruiter;
	private String taxId;

	private Long terminationType;
	private Long employeeContractors;
	private String userName;
	private String password;
    private Long role;

	public Long geteId() {
		return eId;
	}

	public void seteId(Long eId) {
		this.eId = eId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(Long employeeNo) {
		this.employeeNo = employeeNo;
	}

	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public String getAssignmentBranch() {
		return assignmentBranch;
	}

	public void setAssignmentBranch(String assignmentBranch) {
		this.assignmentBranch = assignmentBranch;
	}

	public String getTypeofAction() {
		return typeofAction;
	}

	public void setTypeofAction(String typeofAction) {
		this.typeofAction = typeofAction;
	}

	public String getStreatAddress() {
		return streatAddress;
	}

	public void setStreatAddress(String streatAddress) {
		this.streatAddress = streatAddress;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateorCountry() {
		return stateorCountry;
	}

	public void setStateorCountry(String stateorCountry) {
		this.stateorCountry = stateorCountry;
	}

	public Long getZip() {
		return zip;
	}

	public void setZip(Long zip) {
		this.zip = zip;
	}

	public Long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(Long homePhone) {
		this.homePhone = homePhone;
	}

	public Long getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(Long businessPhone) {
		this.businessPhone = businessPhone;
	}

	public Double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(Double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public Double getOvertimeSalary() {
		return overtimeSalary;
	}

	public void setOvertimeSalary(Double overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}

	public Double getFixedRatePay() {
		return fixedRatePay;
	}

	public void setFixedRatePay(Double fixedRatePay) {
		this.fixedRatePay = fixedRatePay;
	}

	public Double getDailyPayRate() {
		return dailyPayRate;
	}

	public void setDailyPayRate(Double dailyPayRate) {
		this.dailyPayRate = dailyPayRate;
	}

	public Double getPerdiemAllowence() {
		return perdiemAllowence;
	}

	public void setPerdiemAllowence(Double perdiemAllowence) {
		this.perdiemAllowence = perdiemAllowence;
	}

	public Boolean getIsContractReceived() {
		return isContractReceived;
	}

	public void setIsContractReceived(Boolean isContractReceived) {
		this.isContractReceived = isContractReceived;
	}

	public Boolean getIsHRRecievesContract() {
		return isHRRecievesContract;
	}

	public void setIsHRRecievesContract(Boolean isHRRecievesContract) {
		this.isHRRecievesContract = isHRRecievesContract;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

	public String getWorkState() {
		return workState;
	}

	public void setWorkState(String workState) {
		this.workState = workState;
	}

	public Integer getHoursWorkedPerDay() {
		return hoursWorkedPerDay;
	}

	public void setHoursWorkedPerDay(Integer hoursWorkedPerDay) {
		this.hoursWorkedPerDay = hoursWorkedPerDay;
	}

	public Date getNextReviewDate() {
		return nextReviewDate;
	}

	public void setNextReviewDate(Date nextReviewDate) {
		this.nextReviewDate = nextReviewDate;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Boolean getIsCompanyIsAllianceMember() {
		return isCompanyIsAllianceMember;
	}

	public void setIsCompanyIsAllianceMember(Boolean isCompanyIsAllianceMember) {
		this.isCompanyIsAllianceMember = isCompanyIsAllianceMember;
	}

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
	}

	public Boolean getIsSubmissionGuidlineRecieved() {
		return isSubmissionGuidlineRecieved;
	}

	public void setIsSubmissionGuidlineRecieved(Boolean isSubmissionGuidlineRecieved) {
		this.isSubmissionGuidlineRecieved = isSubmissionGuidlineRecieved;
	}

	public String getRcgEmail() {
		return rcgEmail;
	}

	public void setRcgEmail(String rcgEmail) {
		this.rcgEmail = rcgEmail;
	}

	public Boolean getIsHiretoBeach() {
		return isHiretoBeach;
	}

	public void setIsHiretoBeach(Boolean isHiretoBeach) {
		this.isHiretoBeach = isHiretoBeach;
	}

	public Boolean getIsRehiredEmployee() {
		return isRehiredEmployee;
	}

	public void setIsRehiredEmployee(Boolean isRehiredEmployee) {
		this.isRehiredEmployee = isRehiredEmployee;
	}

	public Long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(Long socialSecurityNumber) {
		this.socialSecurityNumber = socialSecurityNumber;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getJobType() {
		return jobType;
	}

	public void setJobType(String jobType) {
		this.jobType = jobType;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getRace() {
		return race;
	}

	public void setRace(String race) {
		this.race = race;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getHireCodes() {
		return hireCodes;
	}

	public void setHireCodes(String hireCodes) {
		this.hireCodes = hireCodes;
	}

	public String getHomeBranch() {
		return homeBranch;
	}

	public void setHomeBranch(String homeBranch) {
		this.homeBranch = homeBranch;
	}

	public String getCPPCareerLevel() {
		return CPPCareerLevel;
	}

	public void setCPPCareerLevel(String cPPCareerLevel) {
		CPPCareerLevel = cPPCareerLevel;
	}

	public List<UserSkillRequestDto> getUserSkills() {
		return userSkills;
	}

	public void setUserSkills(List<UserSkillRequestDto> userSkills) {
		this.userSkills = userSkills;
	}

	public Long getReferralId() {
		return referralId;
	}

	public void setReferralId(Long referralId) {
		this.referralId = referralId;
	}

	public Long getRefLimit() {
		return RefLimit;
	}

	public void setRefLimit(Long refLimit) {
		RefLimit = refLimit;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(Double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public Double getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(Double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

	public Long getDepartment() {
		return department;
	}

	public void setDepartment(Long department) {
		this.department = department;
	}

	public Long getRegion() {
		return region;
	}

	public void setRegion(Long region) {
		this.region = region;
	}

	public Long getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(Long timeZone) {
		this.timeZone = timeZone;
	}

	public Date getTerminationDate() {
		return terminationDate;
	}

	public void setTerminationDate(Date terminationDate) {
		this.terminationDate = terminationDate;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getTaxId() {
		return taxId;
	}

	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}

	public Long getTerminationType() {
		return terminationType;
	}

	public void setTerminationType(Long terminationType) {
		this.terminationType = terminationType;
	}

	public Long getEmployeeContractors() {
		return employeeContractors;
	}

	public void setEmployeeContractors(Long employeeContractors) {
		this.employeeContractors = employeeContractors;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getRole() {
		return role;
	}

	public void setRole(Long role) {
		this.role = role;
	}

	
}
