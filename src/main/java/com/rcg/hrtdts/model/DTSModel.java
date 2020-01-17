package com.rcg.hrtdts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class DTSModel {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Long dtsNo;
	
	@ManyToOne
	private EmployeeModel empId;
	
	
	@ManyToOne
	private RevenueType revenueType;
	
	@ManyToOne
	private ClientModel clientName;
	
	@ManyToOne
	private ProjectModel projectName;
	private Date startDate;
	private Date endDate;
	private String status;
	private String BillRateCurrencyType;
	private String expenseCurrencyType;
	
	@ManyToOne
	private BillingType billingType;
	
	@ManyToOne
	private RegionModel region;
	
	private Double hourlyBillRate;
	private Double additionalExpense;
	private String teamLead;
	
	
	private Long projectManager;
	private String workLocation;
	private String shift;
	
	
	
	
	public String getBillRateCurrencyType() {
		return BillRateCurrencyType;
	}
	public void setBillRateCurrencyType(String billRateCurrencyType) {
		BillRateCurrencyType = billRateCurrencyType;
	}
	public String getExpenseCurrencyType() {
		return expenseCurrencyType;
	}
	public void setExpenseCurrencyType(String expenseCurrencyType) {
		this.expenseCurrencyType = expenseCurrencyType;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public EmployeeModel getEmpId() {
		return empId;
	}
	public void setEmpId(EmployeeModel empId) {
		this.empId = empId;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getDtsNo() {
		return dtsNo;
	}
	public void setDtsNo(Long dtsNo) {
		this.dtsNo = dtsNo;
	}
	public RevenueType getRevenueType() {
		return revenueType;
	}
	public void setRevenueType(RevenueType revenueType) {
		this.revenueType = revenueType;
	}
	public ClientModel getClientName() {
		return clientName;
	}
	public void setClientName(ClientModel clientName) {
		this.clientName = clientName;
	}
	public ProjectModel getProjectName() {
		return projectName;
	}
	public void setProjectName(ProjectModel projectName) {
		this.projectName = projectName;
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
	public BillingType getBillingType() {
		return billingType;
	}
	public void setBillingType(BillingType billingType) {
		this.billingType = billingType;
	}
	public RegionModel getRegion() {
		return region;
	}
	public void setRegion(RegionModel region) {
		this.region = region;
	}
	public Double getHourlyBillRate() {
		return hourlyBillRate;
	}
	public void setHourlyBillRate(Double hourlyBillRate) {
		this.hourlyBillRate = hourlyBillRate;
	}
	public Double getAdditionalExpense() {
		return additionalExpense;
	}
	public void setAdditionalExpense(Double additionalExpense) {
		this.additionalExpense = additionalExpense;
	}
	public String getTeamLead() {
		return teamLead;
	}
	public void setTeamLead(String teamLead) {
		this.teamLead = teamLead;
	}
	public Long getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(Long projectManager) {
		this.projectManager = projectManager;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	
}
