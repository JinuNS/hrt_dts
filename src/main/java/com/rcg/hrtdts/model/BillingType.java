package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BillingType {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long billingTypeId;
	
	private String billingTypeName;

	public Long getBillingTypeId() {
		return billingTypeId;
	}

	public void setBillingTypeId(Long billingTypeId) {
		this.billingTypeId = billingTypeId;
	}

	public String getBillingTypeName() {
		return billingTypeName;
	}

	public void setBillingTypeName(String billingTypeName) {
		this.billingTypeName = billingTypeName;
	}

	
	
	
}
