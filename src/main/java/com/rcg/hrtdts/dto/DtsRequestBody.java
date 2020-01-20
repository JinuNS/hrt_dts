package com.rcg.hrtdts.dto;

import java.util.Date;

import javax.persistence.ManyToOne;

import com.rcg.hrtdts.model.BillingType;
import com.rcg.hrtdts.model.RevenueType;

public class DtsRequestBody {

	private Long dtsNo;

	private Long revenueType;
	private Long empId;
	private Long clientName;
	private Long projectName;
	private Date startDate;
	private Date endDate;
	private Long billingTypeId;
	private Long regionId;
	private Double hourlyBillRate;
	private Double additionalExpense;
	private String teamLead;
	private Long projectManager;
	private String workLocation;
	private String shift;
	private String billRateCurrencyType;
	private String expenseCurrencyType;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public Long getDtsNo() {
		return dtsNo;
	}

	public void setDtsNo(Long dtsNo) {
		this.dtsNo = dtsNo;
	}

	public Long getRevenueType() {
		return revenueType;
	}

	public void setRevenueType(Long revenueType) {
		this.revenueType = revenueType;
	}

	public Long getClientName() {
		return clientName;
	}

	public void setClientName(Long clientName) {
		this.clientName = clientName;
	}

	public Long getProjectName() {
		return projectName;
	}

	public void setProjectName(Long projectName) {
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

	public Long getBillingTypeId() {
		return billingTypeId;
	}

	public void setBillingTypeId(Long billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
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

	public String getBillRateCurrencyType() {
		return billRateCurrencyType;
	}

	public void setBillRateCurrencyType(String billRateCurrencyType) {
		this.billRateCurrencyType = billRateCurrencyType;
	}

	public String getExpenseCurrencyType() {
		return expenseCurrencyType;
	}

	public void setExpenseCurrencyType(String expenseCurrencyType) {
		this.expenseCurrencyType = expenseCurrencyType;
	}

}
