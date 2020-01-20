package com.rcg.hrtdts.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreProcessingDataResponse {

	private List<ClientResponse> clientdata=new ArrayList<ClientResponse>();
	private List<ProjectManagerResponse> projectmanagerData=new ArrayList<ProjectManagerResponse>();
	private List<RevenueTypeResponse> revenueData=new ArrayList<RevenueTypeResponse>();
	private List<BillingTypeResponse> billingData=new ArrayList<BillingTypeResponse>();
	private List<RegionResponse> regionData=new ArrayList<RegionResponse>();
	
	
	public List<ClientResponse> getClientdata() {
		return clientdata;
	}
	public void setClientdata(List<ClientResponse> clientdata) {
		this.clientdata = clientdata;
	}
	
	public List<RevenueTypeResponse> getRevenueData() {
		return revenueData;
	}
	public void setRevenueData(List<RevenueTypeResponse> revenueData) {
		this.revenueData = revenueData;
	}
	public List<ProjectManagerResponse> getProjectmanagerData() {
		return projectmanagerData;
	}
	public void setProjectmanagerData(List<ProjectManagerResponse> projectmanagerData) {
		this.projectmanagerData = projectmanagerData;
	}

	public List<BillingTypeResponse> getBillingData() {
		return billingData;
	}
	public void setBillingData(List<BillingTypeResponse> billingData) {
		this.billingData = billingData;
	}
	public List<RegionResponse> getRegionData() {
		return regionData;
	}
	public void setRegionData(List<RegionResponse> regionData) {
		this.regionData = regionData;
	}

	
	
}
