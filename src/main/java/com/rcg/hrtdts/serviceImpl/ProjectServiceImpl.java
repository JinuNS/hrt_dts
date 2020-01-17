/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/

package com.rcg.hrtdts.serviceImpl;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.ProjectHrtDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.ClientModel;
import com.rcg.hrtdts.model.ContractModel;
import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.ProjectRegion;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.RoleModel;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.model.TimeZoneModel;
import com.rcg.hrtdts.repository.ClientRepository;
import com.rcg.hrtdts.repository.ContractRepository;
import com.rcg.hrtdts.repository.DepartmentRepository;
import com.rcg.hrtdts.repository.EmployeeContractorsRepository;
import com.rcg.hrtdts.repository.EmployeeRepository;
import com.rcg.hrtdts.repository.ProjectRegionRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.repository.RoleRepository;
import com.rcg.hrtdts.repository.TimeZoneRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.EmployeeService;
import com.rcg.hrtdts.service.ProjectService;
import com.rcg.hrtdts.service.RegionService;
import com.rcg.hrtdts.utility.Constants;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectRepository projectRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ClientRepository clientRepository;

	@Autowired
	ContractRepository contractRepository;

	@Autowired
	ProjectRegionRepository projectRegionRepository;

	@Autowired
	private EmployeeService employeeService;

	@Autowired
	private RegionService regionService;

	@Autowired
	RegionRepository regionRepository;
	@Autowired
	TimeZoneRepository timezoneRepository;
	@Autowired
	EmployeeRepository employeeRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	EmployeeContractorsRepository employeeContractorsRepository;
	@Autowired
	RoleRepository roleRepository;

	@Override
	public StatusResponse projectListDataForAdmin(ProjectHrtDto projectHrtDto) throws Exception {
		// TODO Auto-generated method stub
		StatusResponse<Serializable> status = new StatusResponse();
		List<ClientModel> clients = clientRepository.getAll();
		List<ProjectModel> projectlist = projectRepository.getProjectsOnly();
		ArrayList<ContractModel> contract = (ArrayList<ContractModel>) contractRepository.findAll();
		List<RegionModel> region = regionRepository.getlistofRegions();
		ArrayList<TimeZoneModel> timezone = timezoneRepository.getTimeZones1();
		List<EmployeeModel> user_owner = employeeRepository.getProjectOwners();
		List<EmployeeModel> onsite_lead = employeeRepository.getOnsiteLeads();
		List<DepartmentModel> department = ((JpaRepository<DepartmentModel, Long>) departmentRepository).findAll();
		List<EmployeeContractorsModel> employeeContractors = employeeContractorsRepository.findAll();
		List<RoleModel> rolelist = roleRepository.findAll();
		JSONObject clientsobject = new JSONObject();
		JSONObject projectlistobject = new JSONObject();
		JSONObject contractobject = new JSONObject();
		JSONObject regionobject = new JSONObject();
		JSONObject timezoneobject = new JSONObject();
		JSONObject user_ownerobject = new JSONObject();
		JSONObject onsite_leadobject = new JSONObject();
		JSONObject departmentobject = new JSONObject();
		JSONObject employeeContractorsobject = new JSONObject();
		JSONObject rolelistobject = new JSONObject();
		ArrayList<JSONObject> listofObjects = new ArrayList<JSONObject>();
		ArrayList jsonArrayProjects1 = new ArrayList();
		ArrayList jsonArrayProjects2 = new ArrayList();
		ArrayList jsonArrayProjects3 = new ArrayList();
		ArrayList jsonArrayProjects4 = new ArrayList();
		ArrayList jsonArrayProjects5 = new ArrayList();
		ArrayList jsonArrayProjects6 = new ArrayList();
		ArrayList jsonArrayProjects7 = new ArrayList();
		ArrayList jsonArrayProjects8 = new ArrayList();
		ArrayList jsonArrayProjects9 = new ArrayList();

		for (ClientModel client : clients) {
			JSONObject clientjson = new JSONObject();
			clientjson.put("clientId", client.getClientId());
			clientjson.put("clientName", client.getClientName());
			jsonArrayProjects1.add(clientjson);
		}
		clientsobject.put("clientList", jsonArrayProjects1);
		for (ProjectModel project : projectlist) {
			JSONObject projectjson = new JSONObject();
			projectjson.put("projectId", project.getProjectId());
			projectjson.put("projectName", project.getProjectName());
			jsonArrayProjects2.add(projectjson);
		}
		projectlistobject.put("projectList", jsonArrayProjects2);
		for (ContractModel contracts : contract) {
			JSONObject contractjson = new JSONObject();
			contractjson.put("contractTypeId", contracts.getContractTypeId());
			contractjson.put("contractTypeName", contracts.getContractTypeName());
			jsonArrayProjects3.add(contractjson);
		}
		contractobject.put("contractTypeList", jsonArrayProjects3);
		for (RegionModel regions : region) {
			JSONObject regionjson = new JSONObject();
			regionjson.put("regionId", regions.getId());
			regionjson.put("regionName", regions.getRegionName());
			regionjson.put("regionCode", regions.getRegionCode());
			jsonArrayProjects3.add(regionjson);
		}
		regionobject.put("regionList", jsonArrayProjects3);
		for (TimeZoneModel timeZones : timezone) {
			JSONObject timezonejson = new JSONObject();
			timezonejson.put("timezoneId", timeZones.getId());
			timezonejson.put("timezoneName", timeZones.getTimezoneCode());
			timezonejson.put("timezoneCode", timeZones.getTimezoneName());
			jsonArrayProjects4.add(timezonejson);
		}
		timezoneobject.put("timezoneList", jsonArrayProjects4);
		for (EmployeeModel userOwners : user_owner) {
			JSONObject userOwnersjson = new JSONObject();
			userOwnersjson.put("firstName", userOwners.getFirstName());
			userOwnersjson.put("id", userOwners.geteId());
			userOwnersjson.put("lastName", userOwners.getLastName());
			userOwnersjson.put("role", userOwners.getRole().getRoleId());
			userOwnersjson.put("status", userOwners.isActive());
			jsonArrayProjects5.add(userOwnersjson);
		}
		user_ownerobject.put("userownerList", jsonArrayProjects5);
		for (EmployeeModel onsiteLeads : onsite_lead) {
			JSONObject onsiteLeadsjson = new JSONObject();
			onsiteLeadsjson.put("firstName", onsiteLeads.getFirstName());
			onsiteLeadsjson.put("id", onsiteLeads.geteId());
			onsiteLeadsjson.put("lastName", onsiteLeads.getLastName());
			onsiteLeadsjson.put("role", onsiteLeads.getRole().getRoleId());
			onsiteLeadsjson.put("status", onsiteLeads.isActive());
			jsonArrayProjects6.add(onsiteLeadsjson);
		}
		onsite_leadobject.put("onsiteleadList", jsonArrayProjects6);
		for (DepartmentModel dept : department) {
			JSONObject departmentjson = new JSONObject();
			departmentjson.put("departmentId", dept.getDepartmentId());
			departmentjson.put("department", dept.getDepartmentName());
			jsonArrayProjects7.add(departmentjson);
		}
		departmentobject.put("departmentList", jsonArrayProjects7);
		for (EmployeeContractorsModel contractors : employeeContractors) {
			JSONObject contractorsjson = new JSONObject();
			contractorsjson.put("contractorId", contractors.getContractorId());
			contractorsjson.put("contractorName", contractors.getContractorName());
			jsonArrayProjects8.add(contractorsjson);
		}
		employeeContractorsobject.put("contractorList", jsonArrayProjects8);
		for (RoleModel role : rolelist) {
			JSONObject rolejson = new JSONObject();
			rolejson.put("roleId", role.getRoleId());
			rolejson.put("roleName", role.getRoleName());
			jsonArrayProjects9.add(rolejson);
		}
		rolelistobject.put("roleList", jsonArrayProjects9);
		listofObjects.add(projectlistobject);
		listofObjects.add(contractobject);
		listofObjects.add(regionobject);
		listofObjects.add(timezoneobject);
		listofObjects.add(user_ownerobject);
		listofObjects.add(onsite_leadobject);
		listofObjects.add(departmentobject);
		listofObjects.add(employeeContractorsobject);
		listofObjects.add(rolelistobject);

		status = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, listofObjects);
		return status;
	}

	@Override
	public JSONObject createNewProject(ProjectDto projectDto) throws ParseException {
		JSONObject responsedata = new JSONObject();

		ProjectModel project = new ProjectModel();
		Long contractId = projectDto.getContractType();
		ContractModel contractModel = new ContractModel();
		if (contractId != null)
			contractModel = getContract(contractId);
		project.setProjectDetails(projectDto.getProjectDetails());
		project.setProjectType(projectDto.getProjectType());
		project.setWokflowType(projectDto.getWorkflowType());

		Long clientid = projectDto.getClientId();
		ClientModel client = new ClientModel();
		if (clientid != 0L) {
			client = getClientName(clientid);
			project.setClientName(client);
			project.setClientPointOfContact(projectDto.getClientPointOfContact());
		}
		project.setParentProjectId(projectDto.getParentProjectId());
		project.setProjectCategory(projectDto.getProjectCategory());
		project.setProjectName(projectDto.getProjectName());
		project.setIsBillable(projectDto.getIsBillable());
		project.setProjectCode(projectDto.getProjectCode());
		project.setProjectStatus(projectDto.getProjectStatus());
		project.setIsPOC(projectDto.getIsPOC());
		project.setProjectTier(0);
		Long userid = null;

		if (projectDto.getProjectTier() == 1) {
			userid = projectDto.getApproverLevel1();
			EmployeeModel pro_owner = new EmployeeModel();
			if (userid != null)
				pro_owner = employeeService.getUserDetailsById(userid);
			if (pro_owner != null)
				project.setProjectOwner(pro_owner);
			project.setProjectTier(1);
			project.setOnsiteLead(null);
		} else if (projectDto.getProjectTier() == 2) {
			userid = projectDto.getApproverLevel1();
			EmployeeModel pro_owner = new EmployeeModel();
			if (userid != null)
				pro_owner = employeeService.getUserDetailsById(userid);
			if (pro_owner != null)
				project.setProjectOwner(pro_owner);
			Long onsite_lead = projectDto.getApproverLevel2();
			EmployeeModel pro_onsite_lead = new EmployeeModel();
			if (onsite_lead != null) {
				pro_onsite_lead = employeeService.getUserDetailsById(onsite_lead);
			}
			if (pro_onsite_lead != null) {
				project.setOnsiteLead(pro_onsite_lead);
			}
			project.setProjectTier(2);
		}
		if (contractModel != null)
			project.setContract(contractModel);

		project.setEstimatedHours(projectDto.getEstimatedHours());
		Date startdate = projectDto.getStartDate();
		Date enddate = projectDto.getEndDate();
		Date releasingdate = projectDto.getReleasingDate();

		TimeZone zone = TimeZone.getTimeZone("MST");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		formatter.setTimeZone(zone);

		project.setStartDate(formatter.parse(formatter.format(startdate)));
		project.setEndDate(formatter.parse(formatter.format(enddate)));
		project.setReleasingDate(formatter.parse(formatter.format(releasingdate)));

		if ((project.getProjectName() != null) && (!project.getProjectName().equals(" "))
				&& (project.getProjectName().length() > 0) && (project.getProjectCode() != null)
				&& (!project.getProjectCode().equals(" ")) && (project.getProjectCode().length() > 0)) {
			int result = duplicationCheckingProjectCode(project.getProjectCode());

			if (result == 0) {

				ProjectModel projectmodel = saveProjectRecord(project);
				List<Long> regions = null;
				regions = projectDto.getProjectRegion();
				if (projectmodel != null && regions.size() > 0) {

					for (Long region : regions) {
						ProjectRegion projectRegion = new ProjectRegion();
						projectRegion.setProject_Id(projectmodel);
						RegionModel regionmodel = regionService.getregion(region);
						projectRegion.setRegion_Id(regionmodel);
						saveProjectRegion(projectRegion);
					}

				}
				if (projectmodel == null) {
					throw new HRTDTSException("Project record creation failed");
				}
			} else {
				throw new HRTDTSException("Insertion failed due to duplicate entry");
			}

		} else {
			throw new HRTDTSException("Insertion failed due to invalid credientials for project");
		}

		return responsedata;
	}

	public ProjectModel saveProjectRecord(ProjectModel projectmodel) {

		ProjectModel model = projectRepository.save(projectmodel);
		return model;
	}

	public ContractModel getContract(long id) {
		ContractModel contract = contractRepository.getOne(id);
		return contract;
	}

	public ClientModel getClientName(long id) {

		ClientModel getclient = clientRepository.getOne(id);
		return getclient;
	}

	public void saveProjectRegion(ProjectRegion region) {
		projectRegionRepository.save(region);
	}

	public int duplicationCheckingProjectCode(String projectCode) {
		int value = projectRepository.findprojectbycode(projectCode);
		return value;
	}

}
