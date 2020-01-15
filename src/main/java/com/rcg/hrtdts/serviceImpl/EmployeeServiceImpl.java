package com.rcg.hrtdts.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rcg.hrtdts.dto.PreDataDto;
import com.rcg.hrtdts.dto.EmployeeDto;
import com.rcg.hrtdts.dto.UserSkillDto;
import com.rcg.hrtdts.model.EmployeeTypeModel;
import com.rcg.hrtdts.model.GenderModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.EmployeeReferralModel;
import com.rcg.hrtdts.model.EmployeeSkillsModel;
import com.rcg.hrtdts.model.JobTypeModel;
import com.rcg.hrtdts.model.MaritalStatusModel;
import com.rcg.hrtdts.model.RaceModel;
import com.rcg.hrtdts.model.ReferralsModel;
import com.rcg.hrtdts.model.SkillsModel;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.EmployeeTypeRepository;
import com.rcg.hrtdts.repository.GenderRepository;
import com.rcg.hrtdts.repository.EmployeeRepository;
import com.rcg.hrtdts.repository.EmployeeSkillsRepository;
import com.rcg.hrtdts.repository.JobTypeRepository;
import com.rcg.hrtdts.repository.MaritalStatusRepository;
import com.rcg.hrtdts.repository.RaceRepository;
import com.rcg.hrtdts.repository.ReferralsRepository;
import com.rcg.hrtdts.repository.SkillsModelrepository;
import com.rcg.hrtdts.repository.EmployeeReferralsRepository;
import com.rcg.hrtdts.service.EmployeeService;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

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
	private EmployeeSkillsRepository userSkillsRepository;

	@Autowired
	private ReferralsRepository referralsRepository;

	@Autowired
	private EmployeeReferralsRepository userHrtReferralsRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public StatusResponse saveNewHrt(EmployeeDto requestDto) throws Exception {
		StatusResponse response = new StatusResponse();
		EmployeeModel hrtModel = new EmployeeModel();
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

		if (requestDto.getEmployeeType() != null) {
			EmployeeTypeModel employeeType = employeeTypeRepository.findByValue(requestDto.getEmployeeType());
			hrtModel.setEmployeeType(employeeType);
		}
		if (requestDto.getGender() != null) {
			GenderModel gender = genderRepository.findByValue(requestDto.getGender());
			hrtModel.setGender(gender);
		}
		if (requestDto.getJobType() != null) {
			JobTypeModel jobType = jobTypeRepository.findByValue(requestDto.getJobType());
			hrtModel.setJobType(jobType);
		}
		if (requestDto.getMaritalStatus() != null) {
			MaritalStatusModel maritalStatus = maritalStatusRepository.findByValue(requestDto.getMaritalStatus());
			hrtModel.setMaritalStatus(maritalStatus);
		}
		if (requestDto.getRace() != null) {
			RaceModel race = raceRepository.findByValue(requestDto.getRace());
			hrtModel.setRace(race);
		}
		employeeRepository.save(hrtModel);

		// saving user skills
		saveUserhrtSkills(hrtModel, requestDto);

		// saving userHrtReferrals
		saveUserHrtReferrals(hrtModel, requestDto);

		response = new StatusResponse("success", 200, null);
		return response;
	}

	private void saveUserHrtReferrals(EmployeeModel hrtModel, EmployeeDto requestDto) {

		if (requestDto.getReferralId() != null) {
			EmployeeReferralModel userHrtReferralModel = new EmployeeReferralModel();
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

	private void saveUserhrtSkills(EmployeeModel hrtModel, EmployeeDto requestDto) {

		List<EmployeeSkillsModel> userSkillModelList = new ArrayList<EmployeeSkillsModel>();
		if (requestDto.getUserSkills() != null && requestDto.getUserSkills().size() > 0) {
			List<UserSkillDto> skills = requestDto.getUserSkills();
			for (UserSkillDto dto : skills) {
				EmployeeSkillsModel userSkillModel = new EmployeeSkillsModel();
				userSkillModel.setUserHrtModel(hrtModel);
				SkillsModel skillsModel = skillsModelrepository.findBySkillId(dto.getSkillId());
				userSkillModel.setSkills(skillsModel);
				userSkillModel.setSkillLevel(dto.getLevel());
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

	@SuppressWarnings("rawtypes")
	@Override
	public StatusResponse getUserHrtInfo(long id) throws Exception {
		StatusResponse response = new StatusResponse();
		EmployeeModel hrtModel = employeeRepository.findById(id).orElse(null);
		if (hrtModel != null) {
			EmployeeDto responseDto = new EmployeeDto();

			responseDto.setFirstName(hrtModel.getFirstName());
			responseDto.setMiddleName(hrtModel.getMiddleName());
			responseDto.setLastName(hrtModel.getLastName());
			responseDto.setEmployeeNo(hrtModel.getEmployeeNo());
			responseDto.setPersonalEmail(hrtModel.getPersonalEmail());
			responseDto.setHiredate(hrtModel.getHiredate());
			responseDto.setDivision(hrtModel.getDivision());
			responseDto.setAssignmentBranch(hrtModel.getAssignmentBranch());
			responseDto.setTypeofAction(hrtModel.getTypeofAction());
			responseDto.setStreatAddress(hrtModel.getStreatAddress());
			responseDto.setApt(hrtModel.getApt());
			responseDto.setCity(hrtModel.getCity());
			responseDto.setStateorCountry(hrtModel.getStateorCountry());
			responseDto.setZip(hrtModel.getZip());
			responseDto.setHomePhone(hrtModel.getHomePhone());
			responseDto.setBusinessPhone(hrtModel.getBusinessPhone());
			responseDto.setHourlySalary(hrtModel.getHourlySalary());
			responseDto.setOvertimeSalary(hrtModel.getOvertimeSalary());
			responseDto.setFixedRatePay(hrtModel.getFixedRatePay());
			responseDto.setDailyPayRate(hrtModel.getDailyPayRate());
			responseDto.setPerdiemAllowence(hrtModel.getPerdiemAllowence());
			responseDto.setContractReceived(hrtModel.isContractReceived());
			responseDto.setHRRecievesContract(hrtModel.isHRRecievesContract());
			responseDto.setWorkCity(hrtModel.getWorkCity());
			responseDto.setWorkState(hrtModel.getWorkState());
			responseDto.setHoursWorkedPerDay(hrtModel.getHoursWorkedPerDay());
			responseDto.setNextReviewDate(hrtModel.getNextReviewDate());
			responseDto.setComments(hrtModel.getComments());
			responseDto.setCompanyName(hrtModel.getCompanyName());
			responseDto.setCompanyIsAllianceMember(hrtModel.isCompanyIsAllianceMember());
			responseDto.setFederalId(hrtModel.getFederalId());
			responseDto.setSubmissionGuidlineRecieved(hrtModel.isSubmissionGuidlineRecieved());
			responseDto.setRcgEmail(hrtModel.getRcgEmail());
			responseDto.setHiretoBeach(hrtModel.isHiretoBeach());
			responseDto.setRehiredEmployee(hrtModel.isRehiredEmployee());
			responseDto.setSocialSecurityNumber(hrtModel.getSocialSecurityNumber());
			responseDto.setDob(hrtModel.getDob());
			responseDto.setHireCodes(hrtModel.getHireCodes());
			responseDto.setHomeBranch(hrtModel.getHomeBranch());
			responseDto.setCPPCareerLevel(hrtModel.getCPPCareerLevel());
			responseDto.setEmployeeType(hrtModel.getEmployeeType().getValue());
			responseDto.setGender(hrtModel.getGender().getValue());
			responseDto.setJobType(hrtModel.getJobType().getValue());
			responseDto.setMaritalStatus(hrtModel.getMaritalStatus().getValue());
			responseDto.setRace(hrtModel.getRace().getValue());

			List<UserSkillDto> skillDtoList = new ArrayList<UserSkillDto>();
			List<EmployeeSkillsModel> skilsList = userSkillsRepository.findByEId(hrtModel.geteId());
			UserSkillDto skillDto = new UserSkillDto();
			skillDtoList.forEach((empSkills) -> {skillDto.setLevel(empSkills.getLevel());
											  skillDto.setSkillId(empSkills.getSkillId());
			                                  skillDtoList.add(skillDto);});
			
			System.out.println("success");

		}

		return response;
	}

}
