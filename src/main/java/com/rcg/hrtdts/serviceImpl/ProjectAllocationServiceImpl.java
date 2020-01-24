package com.rcg.hrtdts.serviceImpl;

import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rcg.hrtdts.dto.PojectAllocationListDto;
import com.rcg.hrtdts.dto.ProjectAllocationUserListDto;
import com.rcg.hrtdts.dto.ProjectDto;
import com.rcg.hrtdts.dto.SaveAllocationDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.AllocationModel;
import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.LeaveBalanceModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.UserModel;
import com.rcg.hrtdts.repository.AllocationRepository;
import com.rcg.hrtdts.repository.DepartmentRepository;
import com.rcg.hrtdts.repository.LeaveBalanceRepository;
import com.rcg.hrtdts.repository.ProjectRegionRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.ProjectAllocationService;

@Service
public class ProjectAllocationServiceImpl implements ProjectAllocationService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	ProjectRepository projectRepository;
	@Autowired
	ProjectRegionRepository projectRegionrepository;
	@Autowired
	AllocationRepository allocationRepository;
	@Autowired
	DepartmentRepository departmentRepository;
	@Autowired
	LeaveBalanceRepository leaveBalanceRepository;

	@Override
	public JSONObject getProjectlistByRegion(PojectAllocationListDto projectDto) {
		// TODO Auto-generated method stub
		Long roleId = null;
		Long regionId = null;
		Long userId = projectDto.getSessionId();
		Long regionIdSelected = projectDto.getRegionId();
		JSONObject jsonData = new JSONObject();
		ArrayList jsonProjectArray = new ArrayList();
		boolean isLevels = true;
		if (userId == null) {
			throw new HRTDTSException("Invalid user");
		}
		List<ProjectModel> projectList = new ArrayList<ProjectModel>();
		roleId = userRepository.getNonActiveUser(userId).getRole().getRoleId();

		regionId = userRepository.getNonActiveUser(userId).getRegion().getId();

		if ((roleId == 1)) {
			if (regionIdSelected != null) {
				projectList = projectRegionrepository.getProjectsByRegionId(regionIdSelected);
			} else {
				projectList = projectRepository.getAllActiveProjectList();
			}
			isLevels = false;
		}

		if (roleId == 4 | roleId == 3 | roleId == 2) {
			projectList = projectRegionrepository.getProjectsByRegionId(regionId);
			isLevels = false;
		}

		if ((projectList).isEmpty() && projectList.size() == 0 && !isLevels) {
			throw new HRTDTSException("No Data available");
		}
		if (!(projectList).isEmpty() && projectList.size() > 0 && !isLevels) {
			for (ProjectModel project : projectList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("projectId", project.getProjectId());
				jsonObject.put("projectName", project.getProjectName());
				jsonProjectArray.add(jsonObject);
			}
			jsonData.put("projectList", jsonProjectArray);
			return jsonData;
		}
		projectList = projectRepository.getProjectListByLevel1(userId);
		projectList.addAll(projectRepository.getProjectListByLevel2(userId));
		projectList = projectList.stream().distinct().collect(Collectors.toList());
		if ((projectList).isEmpty() && projectList.size() == 0 && isLevels) {
			throw new HRTDTSException("No Data available");
		}
		if (!(projectList).isEmpty() && projectList.size() > 0 && isLevels) {
			for (ProjectModel project : projectList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("projectId", project.getProjectId());
				jsonObject.put("projectName", project.getProjectName());
				jsonProjectArray.add(jsonObject);
			}
			jsonData.put("projectList", jsonProjectArray);
		}
		return jsonData;
	}

	@SuppressWarnings({ "unlikely-arg-type", "unchecked" })
	@Override
	public JSONObject getUserlistByRegion(ProjectAllocationUserListDto projectDto) throws ParseException {
		JSONObject jsonData = new JSONObject();
		List<JSONObject> jsonArrayFiltered = new ArrayList<>();
		TimeZone zone = TimeZone.getTimeZone("MST");
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
		outputFormat.setTimeZone(zone);
		java.util.Date date1 = null, date2 = null;
		Long userId = null;
		Long deptId = null;
		Date startDate, endDate = null;
		Long regionId = null;
		Long sessionId = null;
		Long loginUserRoleId = null;
		Long loginUserRegionId = null;
		startDate = projectDto.getStartDate();
		endDate = projectDto.getEndDate();
		userId = projectDto.getSessionId();
		deptId = projectDto.getDepartmentId();
		regionId = projectDto.getRegionId();
		sessionId = projectDto.getSessionId();
		if (sessionId == null) {
			throw new HRTDTSException("Invalid User");
		}
		loginUserRoleId = userRepository.getNonActiveUser(sessionId).getRole().getRoleId();
		loginUserRegionId = userRepository.getNonActiveUser(sessionId).getRegion().getId();
		if ((userId == null) && (deptId == null) && (regionId == null)) {
			List<UserModel> userList = userRepository.getUserlistByregionAndDepartment(loginUserRegionId);
			if (userList != null) {
				for (UserModel user : userList) {
					getUserAllocationList(user, date1, date2, jsonArrayFiltered);
				}
			}
		} else if ((deptId != null) && (userId == null || userId.equals("0")) && (regionId == null)) {
			List<UserModel> userList = userRepository.getUserByDeptId(deptId);
			if (userList != null) {
				for (UserModel user : userList) {
					getUserAllocationList(user, date1, date2, jsonArrayFiltered);
				}
			}
		} else if ((userId != null && !userId.equals("0")) && (deptId == null) && (regionId == null)) {
			UserModel user = userRepository.getNonActiveUser(userId);
			if (user != null) {
				getUserAllocationList(user, date1, date2, jsonArrayFiltered);
			}
		} else if ((userId == null) && (deptId == null) && (regionId != null)) {
			List<UserModel> userList = userRepository.getUserByRegion(date1, date2, regionId);
			if (userList != null) {
				for (UserModel user : userList) {
					getUserAllocationList(user, date1, date2, jsonArrayFiltered);
				}
			}
		} else if ((userId != null && !userId.equals("0")) && (deptId != null) && (regionId == null)) {
			UserModel user = userRepository.getUser(deptId, userId);
			if (user != null) {
				getUserAllocationList(user, date1, date2, jsonArrayFiltered);
			}
		} else if ((userId != null) && (deptId == null) && (regionId != null)) {
			UserModel user = userRepository.getUserByRegion(regionId, userId);
			if (user != null) {
				getUserAllocationList(user, date1, date2, jsonArrayFiltered);
			}
		} else if ((userId != null && !userId.equals("0")) && (deptId != null) && (regionId != null)) {
			UserModel user = userRepository.getUserBydeptRegion(deptId, userId, regionId);
			if (user != null) {
				getUserAllocationList(user, date1, date2, jsonArrayFiltered);
			}
		}
		jsonData.put("user", jsonArrayFiltered);
		return jsonData;
	}

	@SuppressWarnings("unchecked")
	private void getUserAllocationList(UserModel user, Date date1, Date date2, List<JSONObject> jsonArrayFiltered) {
		Boolean isExist = allocationRepository.isExists(user.getUserId());
		if (isExist) {
			List<AllocationModel> newUserList = allocationRepository.findUsers(user.getUserId(), date1, date2);
			if (newUserList != null && newUserList.size() > 0) {
				JSONObject jsonObject = new JSONObject();
				int freeAlloc = 100;
				int totAlloc = 0;
				List<JSONObject> jsonArray = new ArrayList<>();
				jsonObject.put("userId", user.getUserId());
				jsonObject.put("firstName", user.getEmployee().getFirstName());
				jsonObject.put("lastName", user.getEmployee().getLastName());
				jsonObject.put("roleId", user.getRole().getRoleId());
				jsonObject.put("departmentId", user.getDepartment().getDepartmentId());
				jsonObject.put("regionId", user.getRegion().getId());
				for (AllocationModel item : newUserList) {
					JSONObject jsonObjectData = new JSONObject();
					jsonObjectData.put("allocationId", item.getAllocId());
					jsonObjectData.put("projectId", item.getproject().getProjectId());
					jsonObjectData.put("projectName", item.getproject().getProjectName());
					jsonObjectData.put("projectCategory", item.getproject().getProjectCategory());
					jsonObjectData.put("allocationPercentage", item.getAllocatedPerce());
					jsonObjectData.put("allocationStartDate", item.getStartDate().toString());
					jsonObjectData.put("allocationEndDate", item.getEndDate().toString());
					jsonObjectData.put("isBillable", item.getIsBillable());
					totAlloc += item.getAllocatedPerce();
					if (freeAlloc > 0)
						freeAlloc -= item.getAllocatedPerce();
					jsonArray.add(jsonObjectData);
				}
				jsonObject.put("totalAllocation", totAlloc);
				jsonObject.put("freeAlloc", freeAlloc);
				jsonObject.put("project", jsonArray);
				jsonArrayFiltered.add(jsonObject);
			} else {
				JSONObject jsonObject = new JSONObject();
				List<JSONObject> jsonArray = new ArrayList<>();
				jsonObject.put("userId", user.getUserId());
				jsonObject.put("firstName", user.getEmployee().getFirstName());
				jsonObject.put("lastName", user.getEmployee().getLastName());
				jsonObject.put("roleId", user.getRole().getRoleId());
				jsonObject.put("departmentId", user.getDepartment().getDepartmentId());
				jsonObject.put("project", jsonArray);
				jsonObject.put("freeAlloc", 100);
				jsonObject.put("totalAllocation", 0);
				jsonArrayFiltered.add(jsonObject);
			}
		} else {
			JSONObject jsonObject = new JSONObject();
			List<JSONObject> jsonArray = new ArrayList<>();
			jsonObject.put("userId", user.getUserId());
			jsonObject.put("firstName", user.getEmployee().getFirstName());
			jsonObject.put("lastName", user.getEmployee().getLastName());
			jsonObject.put("roleId", user.getRole().getRoleId());
			jsonObject.put("departmentId", user.getDepartment().getDepartmentId());
			jsonObject.put("project", jsonArray);
			jsonObject.put("freeAlloc", 100);
			jsonObject.put("totalAllocation", 0);
			jsonArrayFiltered.add(jsonObject);
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getUsersByRegion(ProjectDto projectDto) {
		JSONObject jsonData = new JSONObject();
		List<UserModel> userList = null;
		List<DepartmentModel> departmentList = departmentRepository.findDeptName();
		List<ProjectModel> projectList = null;
		ArrayList jsonArray = new ArrayList();
		ArrayList jsonProjectArray = new ArrayList();
		ArrayList jsonDepartmentArray = new ArrayList();
		Long userId = null;
		Long roleId = null;
		Long regionId = null;
		userId = projectDto.getSessionId();
		if (userId == null) {
			throw new HRTDTSException("Invalid user");
		}
		roleId = userRepository.getNonActiveUser(userId).getRole().getRoleId();
		regionId = userRepository.getNonActiveUser(userId).getRegion().getId();
		userList = userRepository.getUserlistByregionAndDepartment(regionId);
		projectList = projectRegionrepository.getProjectsByRegionId(regionId);
		if (!(userList).isEmpty() && userList.size() > 0) {
			for (UserModel user : userList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("userId", user.getUserId());
				jsonObject.put("firstName", user.getEmployee().getFirstName());
				jsonObject.put("lastName", user.getEmployee().getLastName());
				jsonObject.put("roleId", user.getRole().getRoleId());
				jsonObject.put("regionId", user.getRegion().getId());
				DepartmentModel departmentModel = user.getDepartment();
				JSONObject depNode = new JSONObject();
				depNode.put("departmentId", departmentModel.getDepartmentId());
				depNode.put("departmentName", departmentModel.getDepartmentName());
				jsonObject.put("department", depNode);
				LocalDate now = LocalDate.now();
				int quarter = 0;
				int monthNumber = now.getMonthValue();
				int year = now.getYear();
				if (monthNumber >= 1 && monthNumber <= 3)
					quarter = 1;
				else if (monthNumber >= 4 && monthNumber <= 6)
					quarter = 2;
				else if (monthNumber >= 7 && monthNumber <= 9)
					quarter = 3;
				else if (monthNumber >= 10 && monthNumber <= 12)
					quarter = 4;
				LeaveBalanceModel leaveBalanceNode = leaveBalanceRepository.getLeaveBalance(user.getUserId(), quarter,
						year);
				jsonObject.put("leaveBalance", leaveBalanceNode);
				jsonArray.add(jsonObject);
			}
			jsonData.put("userList", jsonArray);
		}
		if (!(projectList).isEmpty() && projectList.size() > 0) {
			for (ProjectModel project : projectList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("projectId", project.getProjectId());
				jsonObject.put("projectName", project.getProjectName());
				jsonProjectArray.add(jsonObject);
			}
			jsonData.put("projectList", jsonProjectArray);
		}
		if (!(departmentList).isEmpty() && departmentList.size() > 0) {
			for (DepartmentModel department : departmentList) {
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("departmentId", department.getDepartmentId());
				jsonObject.put("departmentName", department.getDepartmentName());
				jsonDepartmentArray.add(jsonObject);
			}
			jsonData.put("departmentList", jsonDepartmentArray);
		}
		return jsonData;
	}

	@SuppressWarnings("unchecked")
	@Override
	public JSONObject getResourceListByProjects(ProjectDto projectDto) throws ParseException {
		Long projectId = projectDto.getProjectId();
		Date startDate = projectDto.getStartDate();
		Date endDate = projectDto.getEndDate();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = df.format(startDate);
		String toDate = df.format(endDate);
		List<AllocationModel> allocationModel = allocationRepository.getProjectLists(projectId);
		ArrayList jsonArray = new ArrayList();
		JSONObject jsonData = new JSONObject();
		JSONObject jsonDataRes = new JSONObject();
		if (!(allocationModel.isEmpty() && allocationModel.size() > 0)) {
			for (AllocationModel item : allocationModel) {
				String projectStartDate = df.format(item.getStartDate());
				String projectEndDate = df.format(item.getEndDate());
				if ((fromDate.compareTo(projectStartDate) >= 0 && fromDate.compareTo(projectStartDate) <= 0)
						|| (toDate.compareTo(projectStartDate) >= 0 && toDate.compareTo(projectEndDate) <= 0)
						|| (fromDate.compareTo(projectStartDate) >= 0 && toDate.compareTo(projectEndDate) <= 0)) {
					JSONObject jsonObject = new JSONObject();
					jsonObject.put("allocationId", item.getAllocId());
					if (item.getproject() != null) {
						jsonObject.put("projectTitle", item.getproject().getProjectName());
						jsonObject.put("projectCategory", item.getproject().getProjectCategory());
					}
					if (item.getuser() != null) {
						jsonObject.put("userId", item.getuser().getUserId());
						jsonObject.put("firstName", item.getuser().getEmployee().getFirstName());
						jsonObject.put("lastName", item.getuser().getEmployee().getLastName());
						jsonObject.put("role", item.getuser().getRole().getRoleId());
					}
					jsonObject.put("allocatedVal", item.getAllocatedPerce());
					jsonObject.put("isBillable", item.getIsBillable());
					if (item.getuser() != null && item.getuser().getDepartment() != null)
						jsonObject.put("departmentName", item.getuser().getDepartment().getDepartmentName());
					jsonArray.add(jsonObject);
				}
			}
			jsonData.put("resourceList", jsonArray);
		}
		return jsonData;
	}

	@Override
	public JSONObject saveAllocation(SaveAllocationDto saveAllocationDto) {
		JSONObject responseData = new JSONObject();
		Date startDate = saveAllocationDto.getStartDate();
		Date endDate = saveAllocationDto.getEndDate();
		Double allocatedPercentage = saveAllocationDto.getAllocatedPercentage();
		Long projectId = saveAllocationDto.getProjectId();
		Long userId = saveAllocationDto.getUserId();
		Boolean isBillable = saveAllocationDto.getIsBillable();
		AllocationModel allocation = new AllocationModel();

		ProjectModel project = projectRepository.getOne(projectId);
		UserModel user = userRepository.getNonActiveUser(userId);

		allocation.setproject(project);
		allocation.setuser(user);
		allocation.setStartDate(startDate);
		allocation.setEndDate(endDate);
		allocation.setAllocatedPerce(allocatedPercentage);
		allocation.setIsBillable(isBillable);
		BigInteger allocationID = allocationRepository.getAllocationContinousDateRange(projectId, userId, startDate,
				endDate);
		Long prim_id = null;
		if (allocationID != null) {
			if (allocationID.compareTo(BigInteger.ZERO) > 0) {
				prim_id = allocationID.longValue();
				AllocationModel allocationmodelupdate = allocationRepository.getOne(prim_id);
				long difference = startDate.getTime() - allocationmodelupdate.getEndDate().getTime();
				long diff = TimeUnit.DAYS.convert(difference, TimeUnit.MILLISECONDS);
				if (diff == 1) {
					allocationmodelupdate.setEndDate(endDate);
					allocationmodelupdate.setAllocatedPerce(allocatedPercentage);
					allocationRepository.save(allocationmodelupdate);

				} else {
					allocationRepository.save(allocation);
				}
			}
		} else {
			allocationRepository.save(allocation);
		}
		return responseData;
	}

	@Override
	public JSONObject editAllocation(SaveAllocationDto saveAllocationDto) {
		JSONObject jsonDataRes = new JSONObject();
		Long id = saveAllocationDto.getUserId();
		Double allocatedVal = saveAllocationDto.getAllocatedPercentage();
		Boolean isBillable = saveAllocationDto.getIsBillable();
		Boolean isActive = true;
		AllocationModel allocationModel = allocationRepository.getOne(id);
		if (allocationModel != null) {
			allocationModel.setAllocatedPerce(allocatedVal);
			allocationModel.setIsBillable(isBillable);
			allocationModel.setActive(isActive);
			allocationRepository.save(allocationModel);
		}
		return jsonDataRes;
	}
}
