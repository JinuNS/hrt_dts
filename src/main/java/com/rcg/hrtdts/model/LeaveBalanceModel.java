package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class LeaveBalanceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long leaveBalanceId;
	private double clBalance, elBalance, slBalance;
	private int quarter;
	private int year;
	@OneToOne
	private UserModel user;

	public double getClBalance() {
		return clBalance;
	}

	public void setClBalance(double clBalance) {
		this.clBalance = clBalance;
	}

	public double getElBalance() {
		return elBalance;
	}

	public void setElBalance(double elBalance) {
		this.elBalance = elBalance;
	}

	public double getSlBalance() {
		return slBalance;
	}

	public void setSlBalance(double slBalance) {
		this.slBalance = slBalance;
	}

	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quater) {
		this.quarter = quater;
	}

	public long getLeavebalanceId() {
		return leaveBalanceId;
	}

	public void setLeavebalanceId(long leavebalanceId) {
		this.leaveBalanceId = leavebalanceId;
	}

	public long getLeaveBalanceId() {
		return leaveBalanceId;
	}

	public void setLeaveBalanceId(long leaveBalanceId) {
		this.leaveBalanceId = leaveBalanceId;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
