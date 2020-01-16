package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Region {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String region_name;
	private String region_code;
	private boolean isDeleted;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRegion_name() {
		return region_name;
	}

	public void setRegion_name(String region_name) {
		this.region_name = region_name;
	}

	public String getRegion_code() {
		return region_code;
	}

	public void setRegion_code(String region_code) {
		this.region_code = region_code;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

}
