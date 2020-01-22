package com.rcg.hrtdts.model;

import java.util.Date;
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
public class EmployeeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long eId;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long employeeNo;
	private String personalEmail;
	private Date hiredate;
	@ManyToOne
	private EmployeeTypeModel employeeType;
	private String division;
	private String assignmentBranch;
	private String typeofAction;
	private String streetAddress;
	private String apt;
	private String city;
	private String stateorCountry;
	private Long zip;
	private Long homePhone;
	private Long businessPhone;
	private Double hourlySalary;
	private Double annualSalary;
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
	private String companyCode;
	@ManyToOne
	private GenderModel gender;
	@ManyToOne
	private JobTypeModel jobType;
	@ManyToOne
	private MaritalStatusModel maritalStatus;
	@ManyToOne
	private RaceModel race;
	private Date dob;
	private String hireCodes;
	private String homeBranch;
	private String CPPCareerLevel;
	@ManyToOne
	private DepartmentModel department;
	@ManyToOne
	private RegionModel region;
	@ManyToOne
	private TimeZoneModel timeZone;
	private Date terminationDate;
	private String bloodGroup;
	private String qualification;
	private String homeAddress;
	private String recruiter;
	private String taxId;
	@ManyToOne
	private TerminationTypeModel terminationType;
	@ManyToOne
	private EmployeeContractorsModel employeeContractors;
	@ManyToOne
	private EmployeeStatusModel employeeStatus;

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

	public EmployeeTypeModel getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(EmployeeTypeModel employeeType) {
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

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
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

	public Double getAnnualSalary() {
		return annualSalary;
	}

	public void setAnnualSalary(Double annualSalary) {
		this.annualSalary = annualSalary;
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

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	public GenderModel getGender() {
		return gender;
	}

	public void setGender(GenderModel gender) {
		this.gender = gender;
	}

	public JobTypeModel getJobType() {
		return jobType;
	}

	public void setJobType(JobTypeModel jobType) {
		this.jobType = jobType;
	}

	public MaritalStatusModel getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(MaritalStatusModel maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public RaceModel getRace() {
		return race;
	}

	public void setRace(RaceModel race) {
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

	public DepartmentModel getDepartment() {
		return department;
	}

	public RegionModel getRegion() {
		return region;
	}

	public void setRegion(RegionModel region) {
		this.region = region;
	}

	public TimeZoneModel getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(TimeZoneModel timeZone) {
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

	public void setDepartment(DepartmentModel department) {
		this.department = department;
	}

	public TerminationTypeModel getTerminationType() {
		return terminationType;
	}

	public void setTerminationType(TerminationTypeModel terminationType) {
		this.terminationType = terminationType;
	}

	public EmployeeContractorsModel getEmployeeContractors() {
		return employeeContractors;
	}

	public void setEmployeeContractors(EmployeeContractorsModel employeeContractors) {
		this.employeeContractors = employeeContractors;
	}

	public EmployeeStatusModel getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmployeeStatusModel employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

}