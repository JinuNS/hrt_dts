package com.rcg.hrtdts.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class UserHrtReferralModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private long refLimit;
	private Date startDate;
	private Date endDate;
	private String notes;
	private double ratePerDay;
	private double ratePerHour;
	@ManyToOne
	private UserHrtModel userHrtModel;
	@ManyToOne
	private ReferralsModel referralsModel;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getRefLimit() {
		return refLimit;
	}

	public void setRefLimit(long refLimit) {
		this.refLimit = refLimit;
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

	public UserHrtModel getUserHrtModel() {
		return userHrtModel;
	}

	public void setUserHrtModel(UserHrtModel userHrtModel) {
		this.userHrtModel = userHrtModel;
	}

	public ReferralsModel getReferralsModel() {
		return referralsModel;
	}

	public void setReferralsModel(ReferralsModel referralsModel) {
		this.referralsModel = referralsModel;
	}

}
