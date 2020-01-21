package com.rcg.hrtdts.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.core.IsNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rcg.hrtdts.dto.BillingTypeResponse;
import com.rcg.hrtdts.dto.ClientResponse;
import com.rcg.hrtdts.dto.DtsRequestBody;
import com.rcg.hrtdts.dto.GetDtsDataResponse;
import com.rcg.hrtdts.dto.PreProcessingDataResponse;
import com.rcg.hrtdts.dto.ProjectManagerResponse;
import com.rcg.hrtdts.dto.ProjectResponse;
import com.rcg.hrtdts.dto.RegionResponse;
import com.rcg.hrtdts.dto.RevenueTypeResponse;
import com.rcg.hrtdts.dto.ViewDtsInfoResponse;
import com.rcg.hrtdts.model.BillingType;
import com.rcg.hrtdts.model.ClientModel;
import com.rcg.hrtdts.model.DTSModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.JobTypeModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.RevenueType;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.BillingTypeRepository;
import com.rcg.hrtdts.repository.ClientRepository;
import com.rcg.hrtdts.repository.DTSRepository;
import com.rcg.hrtdts.repository.DepartmentRepository;
import com.rcg.hrtdts.repository.EmployeeRepository;
import com.rcg.hrtdts.repository.JobTypeRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.repository.RevenueTypeRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.service.DTSService;
import com.rcg.hrtdts.utility.Constants;

@Service
public class DTSServiceImpl implements DTSService {

	@Autowired
	private DTSRepository dtsRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RevenueTypeRepository revenueTypeRepository;

	@Autowired
	private BillingTypeRepository billingRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	JobTypeRepository jobTypeRepository;

	@Override
	public StatusResponse getpreProcessingData() throws Exception {

		StatusResponse response = new StatusResponse();

		PreProcessingDataResponse preData = new PreProcessingDataResponse();
		List<ClientResponse> clientvalue = new ArrayList<ClientResponse>();
		List<ProjectManagerResponse> projectManagervalue = new ArrayList<ProjectManagerResponse>();
		List<RevenueTypeResponse> revenuevalue = new ArrayList<RevenueTypeResponse>();
		List<BillingTypeResponse> billingvalue = new ArrayList<BillingTypeResponse>();
		List<RegionResponse> regionvalue = new ArrayList<RegionResponse>();

		ArrayList<Object[]> clientmodel = clientRepository.getAllClientName();

		if (!clientmodel.isEmpty()) {
			for (Object[] obj : clientmodel) {

				ClientResponse clientdata = new ClientResponse();
				clientdata.setClientId(Long.parseLong(obj[0].toString()));
				clientdata.setClientName(obj[1].toString());
				clientvalue.add(clientdata);
			}
			preData.setClientdata(clientvalue);
		}

		ArrayList<Object[]> projectmanagermodel = userRepository.getAllProjectManagers();

		if (!projectmanagermodel.isEmpty()) {
			for (Object[] obj : projectmanagermodel) {

				ProjectManagerResponse managerResponse = new ProjectManagerResponse();
				managerResponse.setProjectManagerId(Long.parseLong(obj[0].toString()));
				String firstname = obj[1] == null ? null : String.valueOf(obj[1]);
				String lastname = obj[2] == null ? null : String.valueOf(obj[2]);
				managerResponse.setProjectManager(firstname + " " + lastname);
				projectManagervalue.add(managerResponse);

			}
			preData.setProjectmanagerData(projectManagervalue);
		}
		List<RevenueType> revenuemodel = revenueTypeRepository.findAll();

		if (!revenuemodel.isEmpty()) {
			for (RevenueType obj : revenuemodel) {

				RevenueTypeResponse revenuedata = new RevenueTypeResponse();
				revenuedata.setRevenueTypeId(obj.getRevenueTypeId());
				revenuedata.setRevenueTypeName(obj.getRevenueTypeName());
				revenuevalue.add(revenuedata);
			}
			preData.setRevenueData(revenuevalue);
		}
		List<BillingType> billingmodel = billingRepository.findAll();

		if (!billingmodel.isEmpty()) {
			for (BillingType obj : billingmodel) {

				BillingTypeResponse billingdata = new BillingTypeResponse();
				billingdata.setBillingTypeId(obj.getBillingTypeId());
				billingdata.setBillingTypeName(obj.getBillingTypeName());
				billingvalue.add(billingdata);
			}
			preData.setBillingData(billingvalue);
		}
		List<RegionModel> regionModel = regionRepository.findAll();

		if (!regionModel.isEmpty()) {
			for (RegionModel obj : regionModel) {

				RegionResponse regionData = new RegionResponse();
				regionData.setRegionId(obj.getId());
				regionData.setRegionName(obj.getRegionName());
				regionvalue.add(regionData);
			}
			preData.setRegionData(regionvalue);
		}
		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, preData);

		return response;
	}

	@Override
	public StatusResponse addNewDTSData(DtsRequestBody requestBody) throws Exception {

		StatusResponse response = new StatusResponse();

		DTSModel dtsmodel = new DTSModel();
		Long dtsnumber = null;
		if (requestBody.getDtsNo() == null) {
			dtsnumber = dtsRepository.getDtsNumber();
			dtsnumber = dtsnumber + 1;

			int checkingstatus = dtsRepository.checkingUserDtsStatus(requestBody.getEmpId());
			if (checkingstatus > 0) {
				response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK,
						"Insertion Not Possible.An Active DTS is available");
				return response;
			}
		} else
			dtsnumber = requestBody.getDtsNo();

		DTSModel dtsdata = dtsRepository.getDtsInformation(dtsnumber);
		if (dtsdata != null) {
			dtsmodel = dtsdata;
		}

		EmployeeModel empModel = employeeRepository.getNonActiveUser(requestBody.getEmpId());
		dtsmodel.setEmpId(empModel);

		dtsmodel.setDtsNo(dtsnumber);

		ClientModel client = clientRepository.getClientData(requestBody.getClientName());
		dtsmodel.setClientName(client);

		ProjectModel project = projectRepository.getProjectdata(requestBody.getProjectName());
		dtsmodel.setProjectName(project);
		dtsmodel.setStartDate(requestBody.getStartDate());
		dtsmodel.setEndDate(requestBody.getEndDate());
		dtsmodel.setStatus(requestBody.getStatus());

//		dtsmodel.setStatus(Constants.DTS_STATUS_NEW);
		BillingType billingtypeobj = billingRepository.findBillingType(requestBody.getBillingTypeId());
		dtsmodel.setBillingType(billingtypeobj);
		RegionModel regionObj = regionRepository.findRegionName(requestBody.getRegionId());
		dtsmodel.setRegion(regionObj);
		dtsmodel.setHourlyBillRate(requestBody.getHourlyBillRate());
		dtsmodel.setAdditionalExpense(requestBody.getAdditionalExpense());
		dtsmodel.setTeamLead(requestBody.getTeamLead());
		dtsmodel.setProjectManager(requestBody.getProjectManager());
		dtsmodel.setWorkLocation(requestBody.getWorkLocation());
		dtsmodel.setShift(requestBody.getShift());
		dtsmodel.setBillRateCurrencyType(requestBody.getBillRateCurrencyType());
		dtsmodel.setExpenseCurrencyType(requestBody.getExpenseCurrencyType());
		RevenueType revenue = revenueTypeRepository.getRevenueData(requestBody.getRevenueType());
		dtsmodel.setRevenueType(revenue);

		dtsRepository.save(dtsmodel);
		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, "Insertion completed");

		return response;
	}

	@Override
	public StatusResponse getDTSData() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		StatusResponse response = new StatusResponse();
		List<ViewDtsInfoResponse> dtsResponse = new ArrayList<ViewDtsInfoResponse>();

		List<EmployeeModel> employeeList = employeeRepository.findAll();

		for (EmployeeModel employeedetail : employeeList) {

			List<Object[]> dtsList = dtsRepository.getAllDtsInformation(employeedetail.geteId());
			if (!dtsList.isEmpty()) {
				for (Object[] obj : dtsList) {

					ViewDtsInfoResponse dtsData = new ViewDtsInfoResponse();
					dtsData.setEmployeeId(employeedetail.geteId());
					dtsData.setEmployeeName(employeedetail.getFirstName() + " " + employeedetail.getLastName());
					dtsData.setCppLevel(employeedetail.getCPPCareerLevel());
					dtsData.setRcgMail(employeedetail.getRcgEmail());
					if (employeedetail.getJobType() != null) {
						JobTypeModel jobtype = jobTypeRepository.findById(employeedetail.getJobType().getId())
								.orElse(null);
						dtsData.setJobType(jobtype.getValue());
					} else
						dtsData.setJobType(null);
					dtsData.setDtsNo(Long.parseLong(obj[1].toString()));
					dtsData.setDtsId(Long.parseLong(obj[0].toString()));
					dtsData.setStatus(obj[4].toString());
					if(dtsData.getStatus().equals(Constants.DTS_STATUS_CLOSED))
						dtsData.setStatus(Constants.DTS_STATUS_ACTIVE_DTS);
					Date startDatee = sdf.parse(obj[5].toString());
					Calendar cal = Calendar.getInstance();
					cal.setTime(startDatee);
					String enddate = obj[6] == null ? null : String.valueOf(obj[6]);

					if (enddate == null) {
						dtsData.setEndDate("");
					} else {
						Date enddatee = sdf.parse(enddate);
						Calendar calender = Calendar.getInstance();
						calender.setTime(enddatee);
						dtsData.setEndDate(String.valueOf(calender.get(Calendar.YEAR) + "-"
								+ (calender.get(Calendar.MONTH) + 1) + "-" + calender.get(Calendar.DATE)));

					}
					dtsData.setStartDate(String.valueOf(cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1)
							+ "-" + cal.get(Calendar.DATE)));

					Long projectid = obj[3] == null ? null : Long.parseLong(obj[3].toString());
					ProjectModel project = new ProjectModel();
					if (projectid != null)
						project = projectRepository.getProjectdata(projectid);
					dtsData.setProjectName(project.getProjectId());
					dtsResponse.add(dtsData);
				}

			} else {
				ViewDtsInfoResponse dtsData = new ViewDtsInfoResponse();
				dtsData.setEmployeeId(employeedetail.geteId());
				dtsData.setEmployeeName(employeedetail.getFirstName() + " " + employeedetail.getLastName());
				dtsData.setCppLevel(employeedetail.getCPPCareerLevel());
				dtsData.setRcgMail(employeedetail.getRcgEmail());
				if (employeedetail.getJobType() != null) {
					JobTypeModel jobtype = jobTypeRepository.findById(employeedetail.getJobType().getId()).orElse(null);
					dtsData.setJobType(jobtype.getValue());
				} else
					dtsData.setJobType(null);

				dtsData.setDtsNo(null);
				dtsData.setDtsId(null);
				dtsData.setStatus(Constants.DTS_STATUS_NO_RECORD);
				dtsData.setEndDate("");
				dtsData.setStartDate("");
				dtsData.setProjectName(null);
				dtsResponse.add(dtsData);

			}
		}

		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, dtsResponse);
		return response;
	}

	@Override
	public StatusResponse getAllClientProjects(Long clientId) {
		ArrayList<Object[]> projectmodel = projectRepository.getAllProjectsByClient(clientId);
		List<ProjectResponse> projectvalue = new ArrayList<ProjectResponse>();

		if (!projectmodel.isEmpty()) {
			for (Object[] obj : projectmodel) {

				ProjectResponse projectResponse = new ProjectResponse();
				projectResponse.setProjectId(Long.parseLong(obj[0].toString()));
				projectResponse.setProjectName(obj[1].toString());
				projectvalue.add(projectResponse);
			}

		}

		StatusResponse response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, projectvalue);
		return response;
	}

	@Override
	public StatusResponse getDTSInformation(Long dtsId) {
		
		DTSModel dtsData = dtsRepository.getDtsData(dtsId);
		GetDtsDataResponse dataResponse = new GetDtsDataResponse();
		if(dtsData.getId()!=null)
			dataResponse.setId(dtsData.getId());
		if (!dtsData.getEmpId().geteId().equals(null))
			dataResponse.setEmpId(dtsData.getEmpId().geteId());
		dataResponse.setEmployeeName(dtsData.getEmpId().getFirstName() + " " + dtsData.getEmpId().getLastName());
		dataResponse.setDtsNo(dtsData.getDtsNo());
		if (!dtsData.getClientName().getClientId().equals(null))
			dataResponse.setClientName(dtsData.getClientName().getClientId());
		if (!dtsData.getProjectName().equals(null))
			dataResponse.setProjectName(dtsData.getProjectName().getProjectId());
		dataResponse.setAdditionalExpense(dtsData.getAdditionalExpense());
		if (!dtsData.getBillingType().getBillingTypeId().equals(null))
			dataResponse.setBillingTypeId(dtsData.getBillingType().getBillingTypeId());
		dataResponse.setBillRateCurrencyType(dtsData.getBillRateCurrencyType());

		if (dtsData.getEndDate() != null)
			dataResponse.setEndDate(dtsData.getEndDate());
		dataResponse.setStartDate(dtsData.getStartDate());
		dataResponse.setExpenseCurrencyType(dtsData.getExpenseCurrencyType());
		if (!dtsData.getRegion().getId().equals(null))
			dataResponse.setRegionId(dtsData.getRegion().getId());
		if (!dtsData.getRevenueType().getRevenueTypeId().equals(null))
			dataResponse.setRevenueType(dtsData.getRevenueType().getRevenueTypeId());
		dataResponse.setTeamLead(dtsData.getTeamLead());
		dataResponse.setProjectManager(dtsData.getProjectManager());
		dataResponse.setShift(dtsData.getShift());
		dataResponse.setWorkLocation(dtsData.getWorkLocation());
		dataResponse.setHourlyBillRate(dtsData.getHourlyBillRate());
		StatusResponse response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, dataResponse);
		return response;
	}

}
