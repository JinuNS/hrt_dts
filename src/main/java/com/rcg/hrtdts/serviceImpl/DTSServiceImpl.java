package com.rcg.hrtdts.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.rcg.hrtdts.dto.DtsRequestBody;
import com.rcg.hrtdts.model.BillingType;
import com.rcg.hrtdts.model.DTSModel;
import com.rcg.hrtdts.model.ProjectManager;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.RevenueType;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.BillingTypeRepository;
import com.rcg.hrtdts.repository.ClientRepository;
import com.rcg.hrtdts.repository.DTSRepository;
import com.rcg.hrtdts.repository.ProjectManagerRepository;
import com.rcg.hrtdts.repository.ProjectRepository;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.repository.RevenueTypeRepository;
import com.rcg.hrtdts.service.DTSService;
import com.rcg.hrtdts.utility.Constants;

@Service
public class DTSServiceImpl implements DTSService {

	@Autowired
	private DTSRepository dtsRepository;

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectManagerRepository projectManagerRepository;
	
	@Autowired
	private RevenueTypeRepository revenueTypeRepository;
	
	@Autowired
	private BillingTypeRepository billingRepository;
	
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public StatusResponse getpreProcessingData() throws Exception {
	
		StatusResponse response = new StatusResponse();
		
		ObjectNode responseData=objectMapper.createObjectNode();
		ArrayNode clientData = objectMapper.createArrayNode();
		ArrayNode projectData=objectMapper.createArrayNode();
		ArrayNode revenueTypeData=objectMapper.createArrayNode();
		ArrayNode billingaTypeData=objectMapper.createArrayNode();
		ArrayNode regionData=objectMapper.createArrayNode();

		ArrayList<Object[]> clientmodel = clientRepository.getAllClientName();

		if (!clientmodel.isEmpty()) {
			for (Object[] obj : clientmodel) {
				ObjectNode data=objectMapper.createObjectNode();
				data.put("clientId", Long.parseLong(obj[0].toString()));
				data.put("clientName", obj[1].toString());
				clientData.add(data);
				
			}
		}
		
		responseData.set("clientNames", clientData);
		ArrayList<Object[]> projectmodel = projectRepository.getAllProjectName();

		if (!projectmodel.isEmpty()) {
			for (Object[] obj : projectmodel) {
				ObjectNode data=objectMapper.createObjectNode();
				data.put("projectId", Long.parseLong(obj[0].toString()));
				data.put("projectName", obj[1].toString());
				projectData.add(data);
				
			}
		}
		responseData.set("projectNames", projectData);
		List<RevenueType> revenuemodel = revenueTypeRepository.findAll();

		if (!revenuemodel.isEmpty()) {
			for (RevenueType obj : revenuemodel) {
				ObjectNode data=objectMapper.createObjectNode();
				data.put("revenueTypeId", obj.getRevenueTypeId());
				data.put("revenueType", obj.getRevenueTypeName());
				revenueTypeData.add(data);
				
			}
		}
		responseData.set("revenueTypes", revenueTypeData);
		List<BillingType> billingmodel = billingRepository.findAll();

		if (!billingmodel.isEmpty()) {
			for (BillingType obj : billingmodel) {
				ObjectNode data=objectMapper.createObjectNode();
				data.put("billingTypeId", obj.getBillingTypeId());
				data.put("billingType", obj.getBillingTypeName());
				billingaTypeData.add(data);
				
			}
		}
		responseData.set("billingTypes", billingaTypeData);
		List<RegionModel> regionModel = regionRepository.findAll();

		if (!regionModel.isEmpty()) {
			for (RegionModel obj : regionModel) {
				ObjectNode data=objectMapper.createObjectNode();
				data.put("regionId", obj.getRegionId());
				data.put("regionName", obj.getRegionName());
				regionData.add(data);
				
			}
		}
		responseData.set("regionNames", regionData);
		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, responseData);

		return response;
	}

	@Override
	public StatusResponse addNewDTSData(DtsRequestBody requestBody) throws Exception{
		
		StatusResponse response=new StatusResponse();
		
		DTSModel dtsmodel=new DTSModel();
		dtsmodel.setDtsNo(requestBody.getDtsNo());
		dtsmodel.setClientName(requestBody.getClientName());
		dtsmodel.setProjectName(requestBody.getProjectName());
		dtsmodel.setStartDate(requestBody.getStartDate());
		dtsmodel.setEndDate(requestBody.getEndDate());
		BillingType billingtypeobj=billingRepository.findBillingType(requestBody.getBillingTypeId());
		dtsmodel.setBillingType(billingtypeobj);
		RegionModel regionObj=regionRepository.findRegionName(requestBody.getRegionId());
		dtsmodel.setRegion(regionObj);
		dtsmodel.setHourlyBillRate(requestBody.getHourlyBillRate());
		dtsmodel.setAdditionalExpense(requestBody.getAdditionalExpense());
		dtsmodel.setTeamLead(requestBody.getTeamLead());
		ProjectManager proManager=projectManagerRepository.getprojectManager(requestBody.getProjectManager());
		
		dtsmodel.setProjectManager(proManager);
		dtsmodel.setWorkLocation(requestBody.getWorkLocation());
		dtsmodel.setShift(requestBody.getShift());
		dtsmodel.setAeName(requestBody.getAeName());
		RevenueType revenue=revenueTypeRepository.getRevenueData(requestBody.getRevenueType());
		dtsmodel.setRevenueType(revenue);
		
		dtsRepository.save(dtsmodel);
		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, "Insertion completed");
		
		return response;
	}

}
