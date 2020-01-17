package com.rcg.hrtdts.model;

import javax.persistence.*;

@Entity
public class EmployeeContractorsModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contractorId;
	private String contractorName;

	public Long getContractorId() {
		return contractorId;
	}

	public void setContractorId(Long contractorId) {
		this.contractorId = contractorId;
	}

	public String getContractorName() {
		return contractorName;
	}

	public void setContractorName(String contractorName) {
		this.contractorName = contractorName;
	}

	public EmployeeContractorsModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EmployeeContractorsModel(Long contractorId, String contractorName) {
		super();
		this.contractorId = contractorId;
		this.contractorName = contractorName;
	}

}
