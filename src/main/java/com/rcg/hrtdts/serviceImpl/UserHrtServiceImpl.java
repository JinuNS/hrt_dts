package com.rcg.hrtdts.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.hrtdts.dto.PreDataDto;
import com.rcg.hrtdts.dto.UserHrtDto;
import com.rcg.hrtdts.dto.UserSkillDto;
import com.rcg.hrtdts.model.EmployeeTypeModel;
import com.rcg.hrtdts.model.GenderModel;
import com.rcg.hrtdts.model.UserHrtModel;
import com.rcg.hrtdts.model.UserHrtReferralModel;
import com.rcg.hrtdts.model.UserHrtSkillsModel;
import com.rcg.hrtdts.model.JobTypeModel;
import com.rcg.hrtdts.model.MaritalStatusModel;
import com.rcg.hrtdts.model.RaceModel;
import com.rcg.hrtdts.model.ReferralsModel;
import com.rcg.hrtdts.model.SkillsModel;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.EmployeeTypeRepository;
import com.rcg.hrtdts.repository.GenderRepository;
import com.rcg.hrtdts.repository.UserHrtRepository;
import com.rcg.hrtdts.repository.UserSkillsRepository;
import com.rcg.hrtdts.repository.JobTypeRepository;
import com.rcg.hrtdts.repository.MaritalStatusRepository;
import com.rcg.hrtdts.repository.RaceRepository;
import com.rcg.hrtdts.repository.ReferralsRepository;
import com.rcg.hrtdts.repository.SkillsModelrepository;
import com.rcg.hrtdts.repository.UserHrtReferralsRepository;
import com.rcg.hrtdts.service.UserHrtService;

@Service
public class UserHrtServiceImpl implements UserHrtService{
	
	@Autowired
	private UserHrtRepository hrtRepository;
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	@Autowired
	private GenderRepository genderRepository;
	
	@Autowired
	private JobTypeRepository jobTypeRepository;
	
	@Autowired
	private MaritalStatusRepository maritalStatusRepository;

	@Autowired
	private RaceRepository raceRepository;
	
	@Autowired
	private SkillsModelrepository skillsModelrepository;
	
	@Autowired
	private UserSkillsRepository userSkillsRepository;
	
	@Autowired
	private ReferralsRepository referralsRepository;
	
	@Autowired
	private UserHrtReferralsRepository userHrtReferralsRepository;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public StatusResponse saveNewHrt(UserHrtDto requestDto) throws Exception{
		StatusResponse response = new StatusResponse();
		UserHrtModel hrtModel = new UserHrtModel();
		hrtModel.setFirstName(requestDto.getFirstName());
		hrtModel.setMiddleName(requestDto.getMiddleName());
		hrtModel.setLastName(requestDto.getLastName());
		hrtModel.setEmployeeNo(requestDto.getEmployeeNo());
		hrtModel.setPersonalEmail(requestDto.getPersonalEmail());
		hrtModel.setHiredate(requestDto.getHiredate());
		hrtModel.setDivision(requestDto.getDivision());
		hrtModel.setAssignmentBranch(requestDto.getAssignmentBranch());
		hrtModel.setTypeofAction(requestDto.getTypeofAction());
		hrtModel.setStreatAddress(requestDto.getStreatAddress());
		hrtModel.setApt(requestDto.getApt());
		hrtModel.setCity(requestDto.getCity());
		hrtModel.setStateorCountry(requestDto.getStateorCountry());
		hrtModel.setZip(requestDto.getZip());
		hrtModel.setHomePhone(requestDto.getHomePhone());
		hrtModel.setBusinessPhone(requestDto.getBusinessPhone());
		hrtModel.setHourlySalary(requestDto.getHourlySalary());
		hrtModel.setOvertimeSalary(requestDto.getOvertimeSalary());
		hrtModel.setFixedRatePay(requestDto.getFixedRatePay());
		hrtModel.setDailyPayRate(requestDto.getDailyPayRate());
		hrtModel.setPerdiemAllowence(requestDto.getPerdiemAllowence());
		hrtModel.setContractReceived(requestDto.isContractReceived());
		hrtModel.setHRRecievesContract(requestDto.isHRRecievesContract());
		hrtModel.setWorkCity(requestDto.getWorkCity());
		hrtModel.setWorkState(requestDto.getWorkState());
		hrtModel.setHoursWorkedPerDay(requestDto.getHoursWorkedPerDay());
		hrtModel.setNextReviewDate(requestDto.getNextReviewDate());
		hrtModel.setComments(requestDto.getComments());
		hrtModel.setCompanyName(requestDto.getCompanyName());
		hrtModel.setCompanyIsAllianceMember(requestDto.isCompanyIsAllianceMember());
		hrtModel.setFederalId(requestDto.getFederalId());
		hrtModel.setSubmissionGuidlineRecieved(requestDto.isSubmissionGuidlineRecieved());
		hrtModel.setRcgEmail(requestDto.getRcgEmail());
		hrtModel.setHiretoBeach(requestDto.isHiretoBeach());
		hrtModel.setRehiredEmployee(requestDto.isRehiredEmployee());
		hrtModel.setSocialSecurityNumber(requestDto.getSocialSecurityNumber());
		hrtModel.setDob(requestDto.getDob());
		hrtModel.setHireCodes(requestDto.getHireCodes());
		hrtModel.setHomeBranch(requestDto.getHomeBranch());
		hrtModel.setCPPCareerLevel(requestDto.getCPPCareerLevel());
		
		if(requestDto.getEmployeeType() != null) {
			EmployeeTypeModel employeeType = employeeTypeRepository.findEmployeeType(requestDto.getEmployeeType());
			hrtModel.setEmployeeType(employeeType);	
		}
		if(requestDto.getGender() != null) {
			GenderModel gender = genderRepository.findGender(requestDto.getGender());
			hrtModel.setGender(gender);
		}
		if(requestDto.getJobType() != null) {
			JobTypeModel jobType = jobTypeRepository.findJobType(requestDto.getJobType());
			hrtModel.setJobType(jobType);
		}
		if(requestDto.getMaritalStatus() != null) {
			MaritalStatusModel maritalStatus = maritalStatusRepository.findMaritalStatus(requestDto.getMaritalStatus());
			hrtModel.setMaritalStatus(maritalStatus);
		}
		if(requestDto.getRace() != null) {
			RaceModel race  = raceRepository.findRace(requestDto.getRace());
			hrtModel.setRace(race);
		}
		hrtRepository.save(hrtModel);

		//saving user skills
		saveUserhrtSkills(hrtModel,requestDto);
	
		//saving userHrtReferrals
		saveUserHrtReferrals(hrtModel,requestDto);
		
		response = new StatusResponse("success", 200, null);
		return response;
	}

	
	
	private void saveUserHrtReferrals(UserHrtModel hrtModel, UserHrtDto requestDto) {

		if(requestDto.getReferralId() != null) {
			UserHrtReferralModel userHrtReferralModel = new UserHrtReferralModel();
			ReferralsModel referralsModel = referralsRepository.findByReferralId(requestDto.getReferralId());
			userHrtReferralModel.setReferralsModel(referralsModel);
			userHrtReferralModel.setUserHrtModel(hrtModel);
			userHrtReferralModel.setEndDate(requestDto.getEndDate());
			userHrtReferralModel.setNotes(requestDto.getNotes());
			userHrtReferralModel.setRatePerDay(requestDto.getRatePerDay());
			userHrtReferralModel.setRatePerHour(requestDto.getRatePerHour());
			userHrtReferralModel.setRefLimit(requestDto.getRefLimit());
			userHrtReferralModel.setStartDate(requestDto.getStartDate());
			userHrtReferralsRepository.save(userHrtReferralModel);
		}
			
	}



	private void saveUserhrtSkills(UserHrtModel hrtModel, UserHrtDto requestDto) {
		
		List<UserHrtSkillsModel> userSkillModelList = new ArrayList<UserHrtSkillsModel>();
		if(requestDto.getUserSkills() != null && requestDto.getUserSkills().size() > 0) {
			List<UserSkillDto> skills = requestDto.getUserSkills();
			for(UserSkillDto dto : skills) {
				UserHrtSkillsModel userSkillModel = new UserHrtSkillsModel();
				userSkillModel.setUserHrtModel(hrtModel);
				SkillsModel skillsModel = skillsModelrepository.findBySkillId(dto.getSkillId());
				userSkillModel.setSkills(skillsModel);
				userSkillModel.setSkill_level(dto.getLevel());
				userSkillModelList.add(userSkillModel);				
			}
			userSkillsRepository.saveAll(userSkillModelList);		
		}
		
	}



	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public StatusResponse getSkillsAndReferrals() throws Exception {
		StatusResponse response = new StatusResponse();
		PreDataDto preDataDto = new PreDataDto();
		List<SkillsModel> skills = skillsModelrepository.findAll();
		List<ReferralsModel> referrals = referralsRepository.findAll();
		preDataDto.setReferrals(referrals);
		preDataDto.setSkills(skills);
		
		response = new StatusResponse("success", 200, preDataDto);
		return response;
	}

}
