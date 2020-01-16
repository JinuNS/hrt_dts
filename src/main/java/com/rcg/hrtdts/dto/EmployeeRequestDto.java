package com.rcg.hrtdts.dto;

import java.util.Date;
import java.util.List;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
public class EmployeeRequestDto {

	private long eId;
	private String firstName;
	private String middleName;
	private String lastName;
	private long employeeNo;
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
	private long zip;
	private long homePhone;
	private long businessPhone;
	private double hourlySalary;
	private double overtimeSalary;
	private double fixedRatePay;
	private double dailyPayRate;
	private double perdiemAllowence;
	private boolean isContractReceived;
	private boolean isHRRecievesContract;
	private String workCity;
	private String workState;
	private int hoursWorkedPerDay;
	private Date nextReviewDate;
	private String comments;
	private String companyName;
	private boolean isCompanyIsAllianceMember;
	private String federalId;
	private boolean isSubmissionGuidlineRecieved;
	private String rcgEmail;
	private boolean isHiretoBeach;
	private boolean isRehiredEmployee;
	private long socialSecurityNumber;
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
	private long RefLimit;
	private Date startDate;
	private Date endDate;
	private String notes;
	private double ratePerDay;
	private double ratePerHour;

	public long geteId() {
		return eId;
	}

	public void seteId(long eId) {
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

	public long getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(long employeeNo) {
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

	public long getZip() {
		return zip;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public long getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(long homePhone) {
		this.homePhone = homePhone;
	}

	public long getBusinessPhone() {
		return businessPhone;
	}

	public void setBusinessPhone(long businessPhone) {
		this.businessPhone = businessPhone;
	}

	public double getHourlySalary() {
		return hourlySalary;
	}

	public void setHourlySalary(double hourlySalary) {
		this.hourlySalary = hourlySalary;
	}

	public double getOvertimeSalary() {
		return overtimeSalary;
	}

	public void setOvertimeSalary(double overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}

	public double getFixedRatePay() {
		return fixedRatePay;
	}

	public void setFixedRatePay(double fixedRatePay) {
		this.fixedRatePay = fixedRatePay;
	}

	public double getDailyPayRate() {
		return dailyPayRate;
	}

	public void setDailyPayRate(double dailyPayRate) {
		this.dailyPayRate = dailyPayRate;
	}

	public double getPerdiemAllowence() {
		return perdiemAllowence;
	}

	public void setPerdiemAllowence(double perdiemAllowence) {
		this.perdiemAllowence = perdiemAllowence;
	}

	public boolean isContractReceived() {
		return isContractReceived;
	}

	public void setContractReceived(boolean isContractReceived) {
		this.isContractReceived = isContractReceived;
	}

	public boolean isHRRecievesContract() {
		return isHRRecievesContract;
	}

	public void setHRRecievesContract(boolean isHRRecievesContract) {
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

	public int getHoursWorkedPerDay() {
		return hoursWorkedPerDay;
	}

	public void setHoursWorkedPerDay(int hoursWorkedPerDay) {
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

	public boolean isCompanyIsAllianceMember() {
		return isCompanyIsAllianceMember;
	}

	public void setCompanyIsAllianceMember(boolean isCompanyIsAllianceMember) {
		this.isCompanyIsAllianceMember = isCompanyIsAllianceMember;
	}

	public String getFederalId() {
		return federalId;
	}

	public void setFederalId(String federalId) {
		this.federalId = federalId;
	}

	public boolean isSubmissionGuidlineRecieved() {
		return isSubmissionGuidlineRecieved;
	}

	public void setSubmissionGuidlineRecieved(boolean isSubmissionGuidlineRecieved) {
		this.isSubmissionGuidlineRecieved = isSubmissionGuidlineRecieved;
	}

	public String getRcgEmail() {
		return rcgEmail;
	}

	public void setRcgEmail(String rcgEmail) {
		this.rcgEmail = rcgEmail;
	}

	public boolean isHiretoBeach() {
		return isHiretoBeach;
	}

	public void setHiretoBeach(boolean isHiretoBeach) {
		this.isHiretoBeach = isHiretoBeach;
	}

	public boolean isRehiredEmployee() {
		return isRehiredEmployee;
	}

	public void setRehiredEmployee(boolean isRehiredEmployee) {
		this.isRehiredEmployee = isRehiredEmployee;
	}

	public long getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	public void setSocialSecurityNumber(long socialSecurityNumber) {
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

	public long getRefLimit() {
		return RefLimit;
	}

	public void setRefLimit(long refLimit) {
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

	public double getRatePerDay() {
		return ratePerDay;
	}

	public void setRatePerDay(double ratePerDay) {
		this.ratePerDay = ratePerDay;
	}

	public double getRatePerHour() {
		return ratePerHour;
	}

	public void setRatePerHour(double ratePerHour) {
		this.ratePerHour = ratePerHour;
	}

}
