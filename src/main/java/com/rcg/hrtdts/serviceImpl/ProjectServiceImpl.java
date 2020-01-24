/**
 * @author  Jinu Shaji
 * @version 1.0
 * @since   2020-01-16
 */

package com.rcg.hrtdts.serviceImpl;

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
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.rcg.hrtdts.dto.AdminProjectListDto;
import com.rcg.hrtdts.dto.ClientResponseDto;
import com.rcg.hrtdts.dto.ContractTypeResponseDto;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.ProjectRegionResponseDto;
import com.rcg.hrtdts.dto.ProjectResponseDto;
import com.rcg.hrtdts.dto.ProjectUserSingleDto;
import com.rcg.hrtdts.dto.SingleProjectResposneDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.ClientModel;
import com.rcg.hrtdts.model.ContractModel;
import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.ProjectRegion;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.Resources;
import com.rcg.hrtdts.model.RoleModel;
import com.rcg.hrtdts.model.TimeZoneModel;
import com.rcg.hrtdts.model.UserModel;
import com.rcg.hrtdts.repository.ClientRepository;
import com.rcg.hrtdts.repository.ContractRepository;
import com.rcg.hrtdts.repository.DepartmentRepository;
import com.rcg.hrtdts.repository.EmployeeContractorsRepository;
import com.rcg.hrtdts.repository.EmployeeRepository;
import com.rcg.hrtdts.repository.ProjectRegionRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.repository.ResourceRepository;
import com.rcg.hrtdts.repository.RoleRepository;
import com.rcg.hrtdts.repository.TimeZoneRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.EmployeeService;
import com.rcg.hrtdts.service.ProjectService;
import com.rcg.hrtdts.service.RegionService;

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

	@Autowired
	ResourceRepository resourceRepository;

	@Override
	public JSONObject createNewProject(ProjectDto projectDto) throws ParseException, HRTDTSException, Exception {
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
			EmployeeModel projectOwner = new EmployeeModel();
			if (userid != null)
				projectOwner = employeeService.getUserDetailsById(userid);
			if (projectOwner != null)
				project.setProjectOwner(projectOwner);
			project.setProjectTier(1);
			project.setOnsiteLead(null);
		} else if (projectDto.getProjectTier() == 2) {
			userid = projectDto.getApproverLevel1();
			EmployeeModel projectOwner = new EmployeeModel();
			if (userid != null)
				projectOwner = employeeService.getUserDetailsById(userid);
			if (projectOwner != null)
				project.setProjectOwner(projectOwner);
			Long onsiteLead = projectDto.getApproverLevel2();
			EmployeeModel projectOnsiteLead = new EmployeeModel();
			if (onsiteLead != null) {
				projectOnsiteLead = employeeService.getUserDetailsById(onsiteLead);
			}
			if (projectOnsiteLead != null) {
				project.setOnsiteLead(projectOnsiteLead);
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
						projectRegion.setProjectId(projectmodel);
						RegionModel regionmodel = regionService.getregion(region);
						projectRegion.setRegionId(regionmodel);
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

	@Override
	public JSONObject updateProject(ProjectDto projectDto) throws ParseException, Exception {
		JSONObject responsedata = new JSONObject();
		ProjectModel project = findById(projectDto.getProjectId());
		Long contractId = projectDto.getContractType();
		ContractModel contractModel = new ContractModel();
		if (contractId != null)
			contractModel = getContract(contractId);
		project.setProjectType(projectDto.getProjectType());
		project.setContract(contractModel);
		Long clientid = projectDto.getClientId();
		ClientModel client = new ClientModel();
		if (clientid != 0L) {
			client = getClientName(clientid);
			project.setClientName(client);
			project.setClientPointOfContact(projectDto.getClientPointOfContact());
		}
		project.setParentProjectId(projectDto.getParentProjectId());
		project.setProjectCategory(projectDto.getProjectCategory());
		project.setProjectDetails(projectDto.getProjectDetails());
		project.setProjectName(projectDto.getProjectName());
		project.setIsBillable(projectDto.getIsBillable());
		project.setProjectCode(projectDto.getProjectCode());
		project.setProjectStatus(projectDto.getProjectStatus());
		project.setWokflowType(projectDto.getWorkflowType());
		project.setIsPOC(projectDto.getIsPOC());
		project.setProjectTier(0);
		Long userid = null;
		if (projectDto.getProjectTier() == 1) {
			userid = projectDto.getApproverLevel1();
			EmployeeModel projectOwner = new EmployeeModel();
			if (userid != null)
				projectOwner = employeeService.getUserDetailsById(userid);
			if (projectOwner != null)
				project.setProjectOwner(projectOwner);
			project.setProjectTier(1);
			project.setOnsiteLead(null);
		}

		else if (projectDto.getProjectTier() == 2) {

			userid = projectDto.getApproverLevel1();
			EmployeeModel projectOwner = new EmployeeModel();

			if (userid != null)
				projectOwner = employeeService.getUserDetailsById(userid);
			if (projectOwner != null)
				project.setProjectOwner(projectOwner);

			Long onsiteLead = projectDto.getApproverLevel2();

			EmployeeModel projectOnsiteLead = new EmployeeModel();

			if (onsiteLead != null) {
				projectOnsiteLead = employeeService.getUserDetailsById(onsiteLead);
			}

			if (projectOnsiteLead != null) {
				project.setOnsiteLead(projectOnsiteLead);
			}

			project.setProjectTier(2);

		}
		project.setEstimatedHours(projectDto.getEstimatedHours());

		TimeZone zone = TimeZone.getTimeZone("MST");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		formatter.setTimeZone(zone);

		project.setStartDate(formatter.parse(formatter.format(projectDto.getStartDate())));
		project.setEndDate(formatter.parse(formatter.format(projectDto.getEndDate())));
		project.setReleasingDate(formatter.parse(formatter.format(projectDto.getReleasingDate())));

		if ((project.getProjectName() != null) && (!project.getProjectName().equals(" "))
				&& (project.getProjectName().length() > 0) && (project.getProjectCode() != null)
				&& (!project.getProjectCode().equals(" ")) && (project.getProjectCode().length() > 0)) {

			ProjectModel projectmodel = saveProjectRecord(project);
			List<Long> regionList = projectDto.getProjectRegion();
			if (projectmodel != null) {
				ArrayList<ProjectRegion> regions = getRegionsByprojectId(projectmodel.getProjectId());

				if (regions.size() > 0) {
					int i = deleteProjectRegions(projectmodel.getProjectId());
					if (i > 0) {
						for (Long region : regionList) {
							ProjectRegion regionedits = new ProjectRegion();
							regionedits.setProjectId(projectmodel);
							RegionModel region1 = regionService.getregion(region);
							regionedits.setRegionId(region1);
							saveProjectRegion(regionedits);
						}
					}
				} else {
					for (Long region : regionList) {
						ProjectRegion regionedits = new ProjectRegion();
						regionedits.setProjectId(projectmodel);
						RegionModel region1 = regionService.getregion(region);
						regionedits.setRegionId(region1);
						saveProjectRegion(regionedits);
					}
				}
			}
		}

		return responsedata;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public AdminProjectListDto projectListDataForAdmin() throws Exception {
        List<ClientModel> clients = clientRepository.getAll();
        List<ProjectModel> projectlist = projectRepository.getProjectsOnly();
        List<ContractModel> contract = contractRepository.findAll();
        List<RegionModel> region = regionRepository.getlistofRegions();
        ArrayList<TimeZoneModel> timezone = timezoneRepository.getTimeZones1();
        List<UserModel> userOwnerList = userRepository.getProjectOwners();
        List<UserModel> onsiteLeadList = userRepository.getOnsiteLeads();
        List<DepartmentModel> department = ((JpaRepository<DepartmentModel, Long>) departmentRepository).findAll();
        List<EmployeeContractorsModel> employeeContractors = employeeContractorsRepository.findAll();
        List<RoleModel> rolelist = roleRepository.findAll();
        AdminProjectListDto adminProjectListDto = new AdminProjectListDto();
        ArrayList projectsUserOwnerList = new ArrayList();
        ArrayList projectsOnsiteLeadList = new ArrayList();
        List<ClientResponseDto> clientResponseDtoList = new ArrayList<ClientResponseDto>();
		if (clients != null) {
			clients.forEach(client -> {
				ClientResponseDto clientDto = new ClientResponseDto();
				clientDto.setClientId(client.getClientId());
				clientDto.setClientName(client.getClientName());
				clientResponseDtoList.add(clientDto);

			});
		}
        adminProjectListDto.setClientResponseDtoList(clientResponseDtoList);
        List<ProjectResponseDto> projectResponseDtoList = new ArrayList<ProjectResponseDto>();
        if (projectlist != null && projectlist.size() > 0) {
            ProjectResponseDto projectResponseDto = new ProjectResponseDto();
            projectlist.forEach(project -> {
                projectResponseDto.setProjectId(project.getProjectId());
                projectResponseDto.setProjectName(project.getProjectName());
                projectResponseDtoList.add(projectResponseDto);
            
            });
        }
        adminProjectListDto.setProjectResponseDtoList(projectResponseDtoList);
        List<ContractTypeResponseDto> contractResponseDtoList = new ArrayList<ContractTypeResponseDto>();
		if (contract != null && contract.size() > 0) {
			ContractTypeResponseDto contractResponseDto = new ContractTypeResponseDto();
			contract.forEach(contracts -> {
				contractResponseDto.setContractTypeId(contracts.getContractTypeId());
				contractResponseDto.setContractTypeName(contracts.getContractTypeName());
				contractResponseDtoList.add(contractResponseDto);

			});
		}
        adminProjectListDto.setContractResponseDtoList(contractResponseDtoList);
        List<ProjectRegionResponseDto> projectRegionResponseDtoList = new ArrayList<ProjectRegionResponseDto>();
		if (region != null && region.size() > 0) {
			region.forEach(regions -> {
				ProjectRegionResponseDto projectRegionResponseDto = new ProjectRegionResponseDto();
				projectRegionResponseDto.setRegionId(regions.getId());
				projectRegionResponseDto.setRegionName(regions.getRegionName());
				projectRegionResponseDto.setRegionCode(regions.getRegionCode());
				projectRegionResponseDtoList.add(projectRegionResponseDto);

			});
		}
        adminProjectListDto.setProjectRegionResponseDtoList(projectRegionResponseDtoList);
        List<TimeZoneModel> timeZoneModelList = new ArrayList<TimeZoneModel>();
		if (timezone != null && timezone.size() > 0) {
			timezone.forEach(timeZones -> {
				TimeZoneModel timeZoneModel = new TimeZoneModel();
				timeZoneModel.setId(timeZones.getId());
				timeZoneModel.setTimezoneName(timeZones.getTimezoneName());
				timeZones.setTimezoneCode(timeZones.getTimezoneCode());
				timeZoneModelList.add(timeZones);

			});
		}
        adminProjectListDto.setTimeZoneModelList(timeZoneModelList);
		if (userOwnerList != null && userOwnerList.size() > 0) {
			userOwnerList.forEach(userOwners -> {
				JSONObject userOwnersjson = new JSONObject();
				userOwnersjson.put("firstName",
						(userOwners.getEmployee() != null) ? userOwners.getEmployee().getFirstName() : null);
				userOwnersjson.put("id", (userOwners.getEmployee() != null) ? userOwners.getEmployee().geteId() : null);
				userOwnersjson.put("lastName",
						(userOwners.getEmployee() != null) ? userOwners.getEmployee().getLastName() : null);
				userOwnersjson.put("role", (userOwners.getRole() != null) ? userOwners.getRole().getRoleId() : null);
				userOwnersjson.put("status", userOwners.getIsActive());
				projectsUserOwnerList.add(userOwnersjson);

			});
		}
        adminProjectListDto.setProjectsUserOwnerList(projectsUserOwnerList);
		if (onsiteLeadList != null && onsiteLeadList.size() > 0) {
			onsiteLeadList.forEach(onsiteLeads -> {
				JSONObject onsiteLeadsjson = new JSONObject();
				onsiteLeadsjson.put("firstName", onsiteLeads.getUserName());
				onsiteLeadsjson.put("id",
						(onsiteLeads.getEmployee() != null) ? onsiteLeads.getEmployee().geteId() : null);
				onsiteLeadsjson.put("lastName",
						(onsiteLeads.getEmployee() != null) ? onsiteLeads.getEmployee().getLastName() : null);
				onsiteLeadsjson.put("role", (onsiteLeads.getRole() != null) ? onsiteLeads.getRole().getRoleId() : null);
				onsiteLeadsjson.put("status", onsiteLeads.getIsActive());
				projectsOnsiteLeadList.add(onsiteLeadsjson);
			});
		}
        adminProjectListDto.setProjectsOnsiteLeadList(projectsOnsiteLeadList);
        List<DepartmentModel> departmentModelList = new ArrayList<DepartmentModel>();
		if (department != null) {
			department.forEach(dept -> {
				DepartmentModel departmentModel = new DepartmentModel();
				departmentModel.setDepartmentId(dept.getDepartmentId());
				departmentModel.setDepartmentName(dept.getDepartmentName());
				departmentModelList.add(departmentModel);
			});
		}
        adminProjectListDto.setDepartmentModelList(departmentModelList);
        List<EmployeeContractorsModel> employeeContractorsList = new ArrayList<EmployeeContractorsModel>();
		if (employeeContractors != null) {
			employeeContractors.forEach(contractors -> {
				EmployeeContractorsModel employeeContractorsModel = new EmployeeContractorsModel();
				employeeContractorsModel.setContractorId(contractors.getContractorId());
				employeeContractorsModel.setContractorName(contractors.getContractorName());
				employeeContractorsList.add(employeeContractorsModel);
			});
		}
        adminProjectListDto.setEmployeeContractorsList(employeeContractorsList);
        List<RoleModel> roleModelList = new ArrayList<RoleModel>();
		if (rolelist != null) {
			rolelist.forEach(role -> {
				RoleModel roleModel = new RoleModel();
				roleModel.setRoleId(role.getRoleId());
				roleModel.setRoleName(role.getRoleName());
				roleModelList.add(roleModel);
			});
		}
        adminProjectListDto.setRoleModelList(roleModelList);
        return adminProjectListDto;
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

	public ProjectModel findById(Long id) {
		ProjectModel model = projectRepository.getOne(id);
		return model;
	}

	public int duplicationChecking(String getprojectName) {
		int value = projectRepository.findProject(getprojectName);
		return value;
	}

	public ArrayList<ProjectRegion> getRegionsByprojectId(long projectId) {
		ArrayList<ProjectRegion> list = (ArrayList<ProjectRegion>) projectRegionRepository.getRegionList(projectId);
		return list;
	}

	public int deleteProjectRegions(long projectId) {
		int i = projectRegionRepository.deleteByProjectId(projectId);
		return i;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<JSONObject> viewAllProjects() throws ParseException, HRTDTSException, Exception {
		ArrayList<JSONObject> finalProjectList = new ArrayList<JSONObject>();
		ArrayList<ProjectModel> projectlist = projectRepository.getAllNonParentProjects();
		if (projectlist.isEmpty()) {
			throw new HRTDTSException("Empty Project List");
		}
		projectlist.forEach(project -> {
			String parentproject = projectRepository.getProjectName(project.getParentProjectId());
			Long eId = project.getProjectOwner() != null ? project.getProjectOwner().geteId() : null;
			JSONObject individualProject = new JSONObject();
			individualProject.put("projectId", project.getProjectId());
			individualProject.put("projectName", project.getProjectName());
			individualProject.put("projectFullName", parentproject + "_" + project.getProjectName());
			individualProject.put("isBillable", project.getIsBillable());
			individualProject.put("projectCode", project.getProjectCode());
			individualProject.put("projectType", project.getProjectType());
			individualProject.put("projectStatus", project.getProjectStatus());
			individualProject.put("workflowType", project.getWokflowType());
			
//			For setting up project region
			ArrayList<Long> projectRegion = new ArrayList<Long>();
			List<ProjectRegion> regionList = projectRegionRepository.getRegionList(project.getProjectId());
			if (regionList.isEmpty()) {
				individualProject.put("projectRegion", projectRegion);
			} else {
				regionList.forEach(region -> {
					projectRegion.add(region.getRegion() != null ? region.getRegion().getId() : null);
				});
				individualProject.put("projectRegion", projectRegion);
			}
			
//			For setting up project client
			JSONObject client = new JSONObject();
			if (project.getClientName() != null) {
				client.put("clientId", project.getClientName() != null ? project.getClientName().getClientId() : null);
				client.put("clientName",
						project.getClientName() != null ? project.getClientName().getClientName() : null);
				individualProject.put("client", client);
			} else {
				client.put("clientId", null);
				client.put("clientName", null);
				individualProject.put("client", client);
			}
			
//			For setting up project contact type
			JSONObject contractType = new JSONObject();
			ContractModel contract = null;
			if (project.getContract() != null) {
				Long contractId = project.getContract().getContractTypeId();
				contract = contractRepository.getOne(contractId);
			}
			if (contract == null)
				contractType = null;
			else {
				contractType.put("contractTypeId", contract.getContractTypeId());
				contractType.put("contractTypeName", contract.getContractTypeName());
			}
			individualProject.put("contractType", contractType);
			
//			For setting up project approver LevelOne
			UserModel nonActiveUsers = null;
			JSONObject approverLevelOne = new JSONObject();
			if (eId != null) {
				nonActiveUsers = userRepository.getNonActiveUser(eId);
			}
			if (nonActiveUsers == null)
				approverLevelOne = null;
			else {
				approverLevelOne.put("firstName",
						nonActiveUsers.getEmployee() != null ? nonActiveUsers.getEmployee().getFirstName() : null);
				approverLevelOne.put("lastName",
						nonActiveUsers.getEmployee() != null ? nonActiveUsers.getEmployee().getLastName() : null);
				approverLevelOne.put("role",
						nonActiveUsers.getRole() != null ? nonActiveUsers.getRole().getRoleId() : null);
				approverLevelOne.put("userId", nonActiveUsers.getEmployee().geteId());
				// approverLevelOne.put("regionId", employee.getRegion().getId());
			}
			individualProject.put("approverLevelOne", approverLevelOne);
			finalProjectList.add(individualProject);
			
			
		});
		return finalProjectList;
	}

	@SuppressWarnings({ "unchecked", "unused" })
	@Override
	public SingleProjectResposneDto getSingleProject(@PathVariable Long projectId) {
		SingleProjectResposneDto singleResponseDto = new SingleProjectResposneDto();
		ProjectModel project = projectRepository.findById(projectId).orElse(null);
		if (project.equals(null)) {
			throw new HRTDTSException("Data Not Availabale");
		} else {
			singleResponseDto.setProjectId(project.getProjectId());
			singleResponseDto.setProjectName(project.getProjectName());
			singleResponseDto.setProjectDetails(project.getProjectDetails());
			singleResponseDto.setParentProjectId(project.getParentProjectId());
			singleResponseDto.setEstimatedHours(project.getEstimatedHours());
			singleResponseDto.setStartDate(project.getStartDate()!=null ?project.getStartDate().toString():null);
			singleResponseDto.setEndDate(project.getEndDate() !=null?project.getEndDate().toString():null);
			singleResponseDto.setIsBillable(project.getIsBillable());
			singleResponseDto.setProjectCategory(project.getProjectCategory());
			singleResponseDto.setProjectCode(project.getProjectCode());
			singleResponseDto.setProjectType(project.getProjectType());
			singleResponseDto.setReleasingDate(project.getReleasingDate() !=null ?project.getReleasingDate().toString():null);
			singleResponseDto.setIsPOC(project.getIsPOC());
			singleResponseDto.setProjectStatus(project.getProjectStatus());
			singleResponseDto.setProjectTier(project.getProjectTier());
			singleResponseDto.setWorkflowType(project.getWokflowType());
			singleResponseDto.setClientPointOfContact(project.getClientPointOfContact());
				
			// Setting the Client Name
			if (project.getClientName() != null) {
				ClientModel clientmodel = clientRepository.findByclientId(project.getClientName().getClientId());
				if (clientmodel == null)
					singleResponseDto.setClientName(null);
				else {
					ClientResponseDto client = new ClientResponseDto();
					client.setClientId(clientmodel.getClientId());
					client.setClientName(clientmodel.getClientName());
					singleResponseDto.setClientName(client);
				}
			} else {
				singleResponseDto.setClientName(null);
			}
			// Setting the Contract Type

			if (project.getContract() != null) {
				ContractModel contractModel = contractRepository.findBycontractTypeId(project.getContract().getContractTypeId());
				if (contractModel == null)
					singleResponseDto.setContractType(null);
				else {
					ContractModel contract = new ContractModel();
					contract.setContractTypeId(contractModel.getContractTypeId());
					contract.setContractTypeName(contractModel.getContractTypeName());
					singleResponseDto.setContractType(contract);
				}
			} else {
				singleResponseDto.setContractType(null);
			}

			// Setting the Approver Level One

			if (project.getProjectOwner() != null) {
				UserModel userModel = userRepository.findByeId(project.getProjectOwner().geteId());
				if (userModel == null)
					singleResponseDto.setApproverLevelOne(null);
				else {
					ProjectUserSingleDto approver1Dto = new ProjectUserSingleDto();
					approver1Dto.setFirstName(userModel.getEmployee() != null ? userModel.getEmployee().getFirstName() : null);
					approver1Dto.setLastName(userModel.getEmployee() != null ? userModel.getEmployee().getLastName() : null);
					approver1Dto.setRole(userModel.getRole() != null ? userModel.getRole().getRoleId() : null);
					approver1Dto.setUserId(userModel.getEmployee() != null ? userModel.getEmployee().geteId() : null);
					singleResponseDto.setApproverLevelOne(approver1Dto);
				}
			} else {
				singleResponseDto.setApproverLevelOne(null);
			}
			
			// Setting the Approver Level Two

			if (project.getOnsiteLead() != null) {
				UserModel leadData = userRepository.findByeId(project.getOnsiteLead().geteId());
				if (leadData == null)
					singleResponseDto.setApproverLevelTwo(null);
				else {
					ProjectUserSingleDto approver2Dto = new ProjectUserSingleDto();
					approver2Dto.setFirstName(leadData.getEmployee() != null ? leadData.getEmployee().getFirstName() : null);
					approver2Dto.setLastName(leadData.getEmployee() != null ? leadData.getEmployee().getLastName() : null);
					approver2Dto.setRole(leadData.getRole() != null ? leadData.getRole().getRoleId() : null);
					approver2Dto.setUserId(leadData.getEmployee() != null ? leadData.getEmployee().geteId() : null);
					singleResponseDto.setApproverLevelOne(approver2Dto);
				}
			} else {
				singleResponseDto.setApproverLevelTwo(null);
			}
			
			// Setting the Project Region

			List<ProjectRegion> regionsList = projectRegionRepository.getRegionList(project.getProjectId());
			ArrayList<Long> regionsArray = new ArrayList<Long>();
			if (regionsList.isEmpty()) {
				singleResponseDto.setProjectRegion(new ArrayList<Long>());
			} else {
				regionsList.forEach(region -> {
					regionsArray.add(region.getRegion().getId() != null ? region.getRegion().getId() : null);

				});
				singleResponseDto.setProjectRegion(regionsArray);
			}
			
			// Setting the Project Resource
			
			List<Resources> resourcelist = resourceRepository.getResourceList(project.getProjectId());
			ArrayList<JSONObject> resourceArray = new ArrayList<JSONObject>();
			if (resourcelist.isEmpty())
				singleResponseDto.setResource(new ArrayList<JSONObject>());
			else {	
				resourcelist.forEach(resource -> {
					JSONObject projectobj = new JSONObject();
					JSONObject resourceobj = new JSONObject();
					resourceobj.put("resourceId", resource.getResourceId());
					resourceobj.put("resourceCount", resource.getresourceCount());

					if (project == null)
						projectobj = null;
					else {
						projectobj.put("projectId", project.getProjectId());
						projectobj.put("projectName", project.getProjectName());
					}
					resourceobj.put("project", projectobj);
					DepartmentModel department = departmentRepository.getOne(resource.getDepartment().getDepartmentId());
					JSONObject departmentobj = new JSONObject();

					if (department == null)
						departmentobj = null;
					else {
						departmentobj.put("departmentId", department.getDepartmentId());
						departmentobj.put("departmentName", department.getDepartmentName());
					}
					resourceobj.put("department", departmentobj);
					resourceArray.add(resourceobj);
				});
				singleResponseDto.setResource(resourceArray);
			}
		}
		return singleResponseDto;
	}


}
