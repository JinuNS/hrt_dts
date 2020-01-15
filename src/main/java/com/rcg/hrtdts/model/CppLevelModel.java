package com.rcg.hrtdts.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CppLevelModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long levelId;
	
	
	private String levelName;


	public long getLevelId() {
		return levelId;
	}


	public void setLevelId(long levelId) {
		this.levelId = levelId;
	}


	public String getLevelName() {
		return levelName;
	}


	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}



	
	
	
}