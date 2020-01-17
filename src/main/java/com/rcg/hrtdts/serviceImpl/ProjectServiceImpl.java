/**
* @author  Jinu Shaji
* @version 1.0
* @since   2020-01-16
*/

package com.rcg.hrtdts.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.model.ClientModel;
import com.rcg.hrtdts.model.ContractModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.ProjectRegion;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.repository.ClientRepository;
import com.rcg.hrtdts.repository.ContractRepository;
import com.rcg.hrtdts.repository.ProjectRegionRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
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
	
	@Override
	public JSONObject createNewProject(ProjectDto projectDto) throws ParseException {
		JSONObject responsedata = new JSONObject();
		int responseflag = 0;

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
			userid = projectDto.getApprover_level_1();
			EmployeeModel pro_owner = new EmployeeModel();
			if (userid != null)
				pro_owner = employeeService.getUserDetailsById(userid);
			if (pro_owner != null)
				project.setProjectOwner(pro_owner);
			project.setProjectTier(1);
			project.setOnsite_lead(null);
		}
		else if (projectDto.getProjectTier() == 2) {
			userid = projectDto.getApprover_level_1();
			EmployeeModel pro_owner = new EmployeeModel();
			if (userid != null)
				pro_owner = employeeService.getUserDetailsById(userid);
			if (pro_owner != null)
				project.setProjectOwner(pro_owner);
			Long onsite_lead = projectDto.getApprover_level_2();
			EmployeeModel pro_onsite_lead = new EmployeeModel();
			if (onsite_lead != null) {
				pro_onsite_lead = employeeService.getUserDetailsById(onsite_lead);
			}
			if (pro_onsite_lead != null) {
				project.setOnsite_lead(pro_onsite_lead);
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

				ProjectModel projectmodel = save_project_record(project);
				List<Long> regions = null;
				regions =  projectDto.getProjectRegion();
				if (projectmodel != null && regions.size()>0) {

					for (Long region : regions) {
						ProjectRegion projectRegion = new ProjectRegion();
						projectRegion.setProject_Id(projectmodel);
						RegionModel regionmodel = regionService.getregion(region);
						projectRegion.setRegion_Id(regionmodel);
						save_project_region(projectRegion);
					}

				}
				if (projectmodel == null) {
					responseflag = 1;
					responsedata.put("message", "Project record creation failed");
				} 
			} else {
				responseflag = 1;
				responsedata.put("message", "Insertion failed due to duplicate entry");
			}

		} else {
			responseflag = 1;
			responsedata.put("message", "Insertion failed due to invalid credientials for project");
		}

		if (responseflag == 0) {
			responsedata.put("status", Constants.SUCCESS);
			responsedata.put("message", "Record Inserted");
		} else {
			responsedata.put("status", Constants.FAILURE);
		}

		return responsedata;
	}

	
	public ProjectModel save_project_record(ProjectModel projectmodel) {

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

	public void save_project_region(ProjectRegion region) {
		// TODO Auto-generated method stub
		ProjectRegion region1 = projectRegionRepository.save(region);
	}
	
	public int duplicationCheckingProjectCode(String projectCode) {
		int value = projectRepository.findprojectbycode(projectCode);
		return value;
	}



}
