package com.rcg.hrtdts.dto;

import java.util.ArrayList;
import java.util.List;

import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.RoleModel;
import com.rcg.hrtdts.model.TimeZoneModel;

public class AdminProjectListDto {
	List<ClientResponseDto> clientResponseDtoList;
	List<ProjectResponseDto> projectResponseDtoList;
	List<ContractTypeResponseDto> contractResponseDtoList;
	List<ProjectRegionResponseDto> projectRegionResponseDtoList;
	List<TimeZoneModel> timeZoneModelList;
	ArrayList projectsUserOwnerList;
	ArrayList projectsOnsiteLeadList;
	List<DepartmentModel> departmentModelList;
	List<EmployeeContractorsModel> employeeContractorsList;
	List<RoleModel> roleModelList;

	public List<ClientResponseDto> getClientResponseDtoList() {
		return clientResponseDtoList;
	}

	public void setClientResponseDtoList(List<ClientResponseDto> clientResponseDtoList) {
		this.clientResponseDtoList = clientResponseDtoList;
	}

	public List<ProjectResponseDto> getProjectResponseDtoList() {
		return projectResponseDtoList;
	}

	public void setProjectResponseDtoList(List<ProjectResponseDto> projectResponseDtoList) {
		this.projectResponseDtoList = projectResponseDtoList;
	}

	public List<ContractTypeResponseDto> getContractResponseDtoList() {
		return contractResponseDtoList;
	}

	public void setContractResponseDtoList(List<ContractTypeResponseDto> contractResponseDtoList) {
		this.contractResponseDtoList = contractResponseDtoList;
	}

	public List<ProjectRegionResponseDto> getProjectRegionResponseDtoList() {
		return projectRegionResponseDtoList;
	}

	public void setProjectRegionResponseDtoList(List<ProjectRegionResponseDto> projectRegionResponseDtoList) {
		this.projectRegionResponseDtoList = projectRegionResponseDtoList;
	}

	public List<TimeZoneModel> getTimeZoneModelList() {
		return timeZoneModelList;
	}

	public void setTimeZoneModelList(List<TimeZoneModel> timeZoneModelList) {
		this.timeZoneModelList = timeZoneModelList;
	}

	public ArrayList getProjectsUserOwnerList() {
		return projectsUserOwnerList;
	}

	public void setProjectsUserOwnerList(ArrayList projectsUserOwnerList) {
		this.projectsUserOwnerList = projectsUserOwnerList;
	}

	public ArrayList getProjectsOnsiteLeadList() {
		return projectsOnsiteLeadList;
	}

	public void setProjectsOnsiteLeadList(ArrayList projectsOnsiteLeadList) {
		this.projectsOnsiteLeadList = projectsOnsiteLeadList;
	}

	public List<DepartmentModel> getDepartmentModelList() {
		return departmentModelList;
	}
	public void setDepartmentModelList(List<DepartmentModel> departmentModelList) {
		this.departmentModelList = departmentModelList;
	}

	public List<EmployeeContractorsModel> getEmployeeContractorsList() {
		return employeeContractorsList;
	}

	public void setEmployeeContractorsList(List<EmployeeContractorsModel> employeeContractorsList) {
		this.employeeContractorsList = employeeContractorsList;
	}

	public List<RoleModel> getRoleModelList() {
		return roleModelList;
	}

	public void setRoleModelList(List<RoleModel> roleModelList) {
		this.roleModelList = roleModelList;
	}

}
