package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RevenueType {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long revenueTypeId;
	
	private String revenueTypeName;

	public Long getRevenueTypeId() {
		return revenueTypeId;
	}

	public void setRevenueTypeId(Long revenueTypeId) {
		this.revenueTypeId = revenueTypeId;
	}

	public String getRevenueTypeName() {
		return revenueTypeName;
	}

	public void setRevenueTypeName(String revenueTypeName) {
		this.revenueTypeName = revenueTypeName;
	}

	
	
}
