package com.rcg.hrtdts.dto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreProcessingDataResponseDto {

	private List<ClientResponseDto> clientdata=new ArrayList<ClientResponseDto>();
	private List<ProjectManagerResponseDto> projectmanagerData=new ArrayList<ProjectManagerResponseDto>();
	private List<RevenueTypeResponseDto> revenueData=new ArrayList<RevenueTypeResponseDto>();
	private List<BillingTypeResponseDto> billingData=new ArrayList<BillingTypeResponseDto>();
	private List<RegionResponseDto> regionData=new ArrayList<RegionResponseDto>();
	
	
	public List<ClientResponseDto> getClientdata() {
		return clientdata;
	}
	public void setClientdata(List<ClientResponseDto> clientdata) {
		this.clientdata = clientdata;
	}
	
	public List<RevenueTypeResponseDto> getRevenueData() {
		return revenueData;
	}
	public void setRevenueData(List<RevenueTypeResponseDto> revenueData) {
		this.revenueData = revenueData;
	}
	public List<ProjectManagerResponseDto> getProjectmanagerData() {
		return projectmanagerData;
	}
	public void setProjectmanagerData(List<ProjectManagerResponseDto> projectmanagerData) {
		this.projectmanagerData = projectmanagerData;
	}

	public List<BillingTypeResponseDto> getBillingData() {
		return billingData;
	}
	public void setBillingData(List<BillingTypeResponseDto> billingData) {
		this.billingData = billingData;
	}
	public List<RegionResponseDto> getRegionData() {
		return regionData;
	}
	public void setRegionData(List<RegionResponseDto> regionData) {
		this.regionData = regionData;
	}

	
	
}
