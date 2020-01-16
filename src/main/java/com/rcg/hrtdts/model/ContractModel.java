package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ContractModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long contractTypeId;
	private String contractTypeName;

	public Long getContractTypeId() {
		return contractTypeId;
	}

	public void setContractTypeId(Long contractTypeId) {
		this.contractTypeId = contractTypeId;
	}

	public String getContractTypeName() {
		return contractTypeName;
	}

	public void setContractTypeName(String contractTypeName) {
		this.contractTypeName = contractTypeName;
	}

	public ContractModel(long contractTypeId, String contractTypeName) {
		super();
		this.contractTypeId = contractTypeId;
		this.contractTypeName = contractTypeName;
	}

	public ContractModel() {

	}
}
