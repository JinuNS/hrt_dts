package com.rcg.hrtdts.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="client")
public class ClientModel {
	
	@Id
	@Column(name="clientId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clientId;
	
	private String clientName;
	private String clientLocation;
	private String clientCountry;
	private String timeZone;
	private String consultantName;
	private String consultantLocation;
	private int clientType;
	
	public ClientModel() {
		
	}	
	
	public ClientModel(long clientId, String clientName, String clientLocation, String clientCountry, String timeZone,
			String consultantName, String consultantLocation, int clientType) {
		super();
		this.clientId = clientId;
		this.clientName = clientName;
		this.consultantLocation = consultantLocation;
		this.clientCountry = clientCountry;
		this.timeZone = timeZone;
		this.consultantName = consultantName;
		this.consultantLocation = consultantLocation;
		this.clientType = clientType;
	}
	public long getClientId() {
		return clientId;
	}
	public void setClientId(long clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	
	
	
	public String getClientLocation() {
		return clientLocation;
	}

	public void setClientLocation(String clientLocation) {
		this.clientLocation = clientLocation;
	}

	public String getClientCountry() {
		return clientCountry;
	}

	public void setClientCountry(String clientCountry) {
		this.clientCountry = clientCountry;
	}

	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getConsultantName() {
		return consultantName;
	}
	public void setConsultantName(String consultantName) {
		this.consultantName = consultantName;
	}
	public String getConsultantLocation() {
		return consultantLocation;
	}
	public void setConsultantLocation(String consultantLocation) {
		this.consultantLocation = consultantLocation;
	}
	public int getClientType() {
		return clientType;
	}
	public void setClientType(int clientType) {
		this.clientType = clientType;
	}
	
	
	
}
