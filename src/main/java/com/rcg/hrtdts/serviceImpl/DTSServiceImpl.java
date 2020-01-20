package com.rcg.hrtdts.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rcg.hrtdts.dto.BillingTypeResponseDto;
import com.rcg.hrtdts.dto.ClientResponseDto;
import com.rcg.hrtdts.dto.DtsRequestBodyDto;
import com.rcg.hrtdts.dto.GetDtsDataResponseDto;
import com.rcg.hrtdts.dto.PreProcessingDataResponseDto;
import com.rcg.hrtdts.dto.ProjectManagerResponseDto;
import com.rcg.hrtdts.dto.ProjectResponseDto;
import com.rcg.hrtdts.dto.RegionResponseDto;
import com.rcg.hrtdts.dto.RevenueTypeResponseDto;
import com.rcg.hrtdts.dto.ViewDtsInfoResponseDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.BillingType;
import com.rcg.hrtdts.model.ClientModel;
import com.rcg.hrtdts.model.DTSModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.JobTypeModel;
import com.rcg.hrtdts.model.ProjectModel;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.RevenueType;
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
	public PreProcessingDataResponseDto getpreProcessingData() throws Exception {

		PreProcessingDataResponseDto preData = new PreProcessingDataResponseDto();
		List<ClientResponseDto> clientvalue = new ArrayList<ClientResponseDto>();
		List<ProjectManagerResponseDto> projectManagervalue = new ArrayList<ProjectManagerResponseDto>();
		List<RevenueTypeResponseDto> revenuevalue = new ArrayList<RevenueTypeResponseDto>();
		List<BillingTypeResponseDto> billingvalue = new ArrayList<BillingTypeResponseDto>();
		List<RegionResponseDto> regionvalue = new ArrayList<RegionResponseDto>();

		ArrayList<Object[]> clientmodel = clientRepository.getAllClientName();

		if (!clientmodel.isEmpty()) {
			for (Object[] obj : clientmodel) {

				ClientResponseDto clientdata = new ClientResponseDto();
				clientdata.setClientId(Long.parseLong(obj[0].toString()));
				clientdata.setClientName(obj[1].toString());
				clientvalue.add(clientdata);
			}
			preData.setClientdata(clientvalue);
		}

		ArrayList<Object[]> projectmanagermodel = userRepository.getAllProjectManagers();

		if (!projectmanagermodel.isEmpty()) {
			for (Object[] obj : projectmanagermodel) {

				ProjectManagerResponseDto managerResponse = new ProjectManagerResponseDto();
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

				RevenueTypeResponseDto revenuedata = new RevenueTypeResponseDto();
				revenuedata.setRevenueTypeId(obj.getRevenueTypeId());
				revenuedata.setRevenueTypeName(obj.getRevenueTypeName());
				revenuevalue.add(revenuedata);
			}
			preData.setRevenueData(revenuevalue);
		}
		List<BillingType> billingmodel = billingRepository.findAll();

		if (!billingmodel.isEmpty()) {
			for (BillingType obj : billingmodel) {

				BillingTypeResponseDto billingdata = new BillingTypeResponseDto();
				billingdata.setBillingTypeId(obj.getBillingTypeId());
				billingdata.setBillingTypeName(obj.getBillingTypeName());
				billingvalue.add(billingdata);
			}
			preData.setBillingData(billingvalue);
		}
		List<RegionModel> regionModel = regionRepository.findAll();

		if (!regionModel.isEmpty()) {
			for (RegionModel obj : regionModel) {

				RegionResponseDto regionData = new RegionResponseDto();
				regionData.setRegionId(obj.getId());
				regionData.setRegionName(obj.getRegionName());
				regionvalue.add(regionData);
			}
			preData.setRegionData(regionvalue);
		}
		return preData;
	}

	@Override
	public void addNewDTSData(DtsRequestBodyDto requestBody) throws Exception, HRTDTSException {

		DTSModel dtsmodel = new DTSModel();
		Long dtsnumber = null;
		if (requestBody.getDtsNo() == null) {
			dtsnumber = dtsRepository.getDtsNumber();
			dtsnumber = dtsnumber + 1;

			int checkingstatus = dtsRepository.checkingUserDtsStatus(requestBody.getEmpId());
			if (checkingstatus > 0) {

				throw new HRTDTSException("Insertion Not Possible.An Active DTS is available");

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

	}

	@Override
	public List<ViewDtsInfoResponseDto> getDTSData() throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ViewDtsInfoResponseDto> dtsResponse = new ArrayList<ViewDtsInfoResponseDto>();

		List<EmployeeModel> employeeList = employeeRepository.findAll();

		for (EmployeeModel employeedetail : employeeList) {

			List<Object[]> dtsList = dtsRepository.getAllDtsInformation(employeedetail.geteId());
			if (!dtsList.isEmpty()) {
				for (Object[] obj : dtsList) {

					ViewDtsInfoResponseDto dtsData = new ViewDtsInfoResponseDto();
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
					if (dtsData.getStatus().equals(Constants.DTS_STATUS_CLOSED))
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
				ViewDtsInfoResponseDto dtsData = new ViewDtsInfoResponseDto();
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

		return dtsResponse;
	}

	@Override
	public List<ProjectResponseDto> getAllClientProjects(Long clientId) {
		ArrayList<Object[]> projectmodel = projectRepository.getAllProjectsByClient(clientId);
		List<ProjectResponseDto> projectvalue = new ArrayList<ProjectResponseDto>();

		if (!projectmodel.isEmpty()) {
			for (Object[] obj : projectmodel) {

				ProjectResponseDto projectResponse = new ProjectResponseDto();
				projectResponse.setProjectId(Long.parseLong(obj[0].toString()));
				projectResponse.setProjectName(obj[1].toString());
				projectvalue.add(projectResponse);
			}

		}

		return projectvalue;
	}

	@Override
	public GetDtsDataResponseDto getDTSInformation(Long dtsId) {

		DTSModel dtsData = dtsRepository.getDtsData(dtsId);
		GetDtsDataResponseDto dataResponse = new GetDtsDataResponseDto();
		if (dtsData.getId() != null)
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
		return dataResponse;
	}

}
