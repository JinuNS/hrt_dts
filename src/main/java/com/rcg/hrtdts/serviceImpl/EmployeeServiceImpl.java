package com.rcg.hrtdts.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rcg.hrtdts.dto.PreDataDto;
import com.rcg.hrtdts.dto.EmployeeRequestDto;
import com.rcg.hrtdts.dto.EmployeeResponseDto;
import com.rcg.hrtdts.dto.UserSkillRequestDto;
import com.rcg.hrtdts.dto.UserSkillResponseDto;
import com.rcg.hrtdts.model.EmployeeTypeModel;
import com.rcg.hrtdts.model.GenderModel;
import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.EmployeeReferralModel;
import com.rcg.hrtdts.model.EmployeeTechnologyModel;
import com.rcg.hrtdts.model.JobTypeModel;
import com.rcg.hrtdts.model.MaritalStatusModel;
import com.rcg.hrtdts.model.RaceModel;
import com.rcg.hrtdts.model.ReferralsModel;
import com.rcg.hrtdts.model.RegionModel;
import com.rcg.hrtdts.model.RoleModel;
import com.rcg.hrtdts.model.TechnologyModel;
import com.rcg.hrtdts.model.TerminationTypeModel;
import com.rcg.hrtdts.model.TimeZoneModel;
import com.rcg.hrtdts.model.UserModel;
import com.rcg.hrtdts.model.StatusResponse;
import com.rcg.hrtdts.repository.EmployeeTypeRepository;
import com.rcg.hrtdts.repository.GenderRepository;
import com.rcg.hrtdts.repository.EmployeeRepository;
import com.rcg.hrtdts.repository.EmployeeTechnologyRepository;
import com.rcg.hrtdts.repository.JobTypeRepository;
import com.rcg.hrtdts.repository.MaritalStatusRepository;
import com.rcg.hrtdts.repository.RaceRepository;
import com.rcg.hrtdts.repository.ReferralsRepository;
import com.rcg.hrtdts.repository.RegionRepository;
import com.rcg.hrtdts.repository.RoleRepository;
import com.rcg.hrtdts.repository.TechnologyRepository;
import com.rcg.hrtdts.repository.TerminationTypeRepository;
import com.rcg.hrtdts.repository.TimeZoneRepository;
import com.rcg.hrtdts.repository.UserRepository;
import com.rcg.hrtdts.repository.DepartmentRepository;
import com.rcg.hrtdts.repository.EmployeeContractorsRepository;
import com.rcg.hrtdts.repository.EmployeeReferralsRepository;
import com.rcg.hrtdts.service.EmployeeService;
import com.rcg.hrtdts.utility.Constants;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
@Service
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
	private TechnologyRepository technologyRepository;

	@Autowired
	private EmployeeTechnologyRepository userTechnologyRepository;

	@Autowired
	private ReferralsRepository referralsRepository;

	@Autowired
	private EmployeeReferralsRepository userHrtReferralsRepository;

	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private RegionRepository regionRepository;

	@Autowired
	private TimeZoneRepository timeZoneRepository;

	@Autowired
	private EmployeeContractorsRepository employeeContractorsRepository;

	@Autowired
	private TerminationTypeRepository terminationTypeRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public StatusResponse saveEmployeeInfo(EmployeeRequestDto requestDto) throws Exception {
		StatusResponse response = new StatusResponse();
		EmployeeModel hrtModel = new EmployeeModel();
		if (requestDto.geteId() != null) {
			hrtModel = employeeRepository.findById(requestDto.geteId()).orElse(new EmployeeModel());
		}
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
		hrtModel.setIsContractReceived(requestDto.getIsContractReceived());
		hrtModel.setIsHRRecievesContract(requestDto.getIsHRRecievesContract());
		hrtModel.setWorkCity(requestDto.getWorkCity());
		hrtModel.setWorkState(requestDto.getWorkState());
		hrtModel.setHoursWorkedPerDay(requestDto.getHoursWorkedPerDay());
		hrtModel.setNextReviewDate(requestDto.getNextReviewDate());
		hrtModel.setComments(requestDto.getComments());
		hrtModel.setCompanyName(requestDto.getCompanyName());
		hrtModel.setIsCompanyIsAllianceMember(requestDto.getIsCompanyIsAllianceMember());
		hrtModel.setFederalId(requestDto.getFederalId());
		hrtModel.setIsSubmissionGuidlineRecieved(requestDto.getIsSubmissionGuidlineRecieved());
		hrtModel.setRcgEmail(requestDto.getRcgEmail());
		hrtModel.setIsHiretoBeach(requestDto.getIsHiretoBeach());
		hrtModel.setIsRehiredEmployee(requestDto.getIsRehiredEmployee());
		hrtModel.setSocialSecurityNumber(requestDto.getSocialSecurityNumber());
		hrtModel.setDob(requestDto.getDob());
		hrtModel.setHireCodes(requestDto.getHireCodes());
		hrtModel.setHomeBranch(requestDto.getHomeBranch());
		hrtModel.setCPPCareerLevel(requestDto.getCPPCareerLevel());
		hrtModel.setTerminationDate(requestDto.getTerminationDate());
		hrtModel.setBloodGroup(requestDto.getBloodGroup());
		hrtModel.setQualification(requestDto.getQualification());
		hrtModel.setHomeAddress(requestDto.getHomeAddress());
		hrtModel.setRecruiter(requestDto.getRecruiter());
		hrtModel.setTaxId(requestDto.getTaxId());

		if (requestDto.getDepartment() != null) {
			DepartmentModel department = departmentRepository.findById(requestDto.getDepartment()).orElse(null);
			hrtModel.setDepartment(department);
		}
		if (requestDto.getRegion() != null) {
			RegionModel region = regionRepository.findById(requestDto.getRegion()).orElse(null);
			hrtModel.setRegion(region);
		}
		if (requestDto.getTimeZone() != null) {
			TimeZoneModel timezone = timeZoneRepository.findById(requestDto.getTimeZone()).orElse(null);
			hrtModel.setTimeZone(timezone);
		}
		if (requestDto.getEmployeeContractors() != null) {
			EmployeeContractorsModel vendor = employeeContractorsRepository
					.findById(requestDto.getEmployeeContractors()).orElse(null);
			hrtModel.setEmployeeContractors(vendor);
		}
		if (requestDto.getTerminationType() != null) {
			TerminationTypeModel terminationType = terminationTypeRepository.findById(requestDto.getTerminationType())
					.orElse(null);
			hrtModel.setTerminationType(terminationType);
		}
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
		boolean isSkillsExists = userTechnologyRepository.existsByEId(hrtModel.geteId());
		if (isSkillsExists) {
			userTechnologyRepository.deleteByUserHrtModelEId(hrtModel.geteId());
		}
		saveUserhrtSkills(hrtModel, requestDto);

		// saving userHrtReferrals
		boolean isReferralsExists = userHrtReferralsRepository.existsByEId(hrtModel.geteId());
		if (isReferralsExists) {
			userHrtReferralsRepository.deleteByUserHrtModelEId(hrtModel.geteId());
		}
		saveUserHrtReferrals(hrtModel, requestDto);

		// saving employeeCredentials
		saveEmployeeCredentials(hrtModel, requestDto);

		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, null);
		return response;
	}

	private void saveEmployeeCredentials(EmployeeModel hrtModel, EmployeeRequestDto requestDto) {

		UserModel user = new UserModel();

		Boolean isUserExists = userRepository.existsByEId(hrtModel.geteId());
		if (isUserExists) {
			user = userRepository.findByeId(hrtModel.geteId());
		}

		user.seteId(hrtModel.geteId());
		user.setEmail(hrtModel.getRcgEmail());
		if (requestDto.getRole() != null) {
			RoleModel role = roleRepository.findById(requestDto.getRole()).orElse(null);
			user.setRole(role);
		}
		user.setUserName(requestDto.getUserName());
		user.setPassword(requestDto.getPassword());
		userRepository.save(user);
	}

	private void saveUserHrtReferrals(EmployeeModel hrtModel, EmployeeRequestDto requestDto) {

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

	private void saveUserhrtSkills(EmployeeModel hrtModel, EmployeeRequestDto requestDto) {

		List<EmployeeTechnologyModel> userSkillModelList = new ArrayList<EmployeeTechnologyModel>();
		if (requestDto.getUserSkills() != null && requestDto.getUserSkills().size() > 0) {
			List<UserSkillRequestDto> skills = requestDto.getUserSkills();
			for (UserSkillRequestDto dto : skills) {
				EmployeeTechnologyModel userSkillModel = new EmployeeTechnologyModel();
				userSkillModel.setUserHrtModel(hrtModel);
				TechnologyModel skillsModel = technologyRepository.findById(dto.getSkillId()).orElse(new TechnologyModel());
				userSkillModel.setSkills(skillsModel);
				userSkillModel.setSkillLevel(dto.getLevel());
				userSkillModelList.add(userSkillModel);
			}
			userTechnologyRepository.saveAll(userSkillModelList);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public StatusResponse getSkillsAndReferrals() throws Exception {
		StatusResponse response = new StatusResponse();
		PreDataDto preDataDto = new PreDataDto();
		List<TechnologyModel> skills = technologyRepository.findAll();
		List<ReferralsModel> referrals = referralsRepository.findAll();
		List<RegionModel> region = regionRepository.findAll();
		List<DepartmentModel> department = departmentRepository.findAll();
		List<TimeZoneModel> timeZone = timeZoneRepository.findAll();
		List<TerminationTypeModel> terminationType = terminationTypeRepository.findAll();
		List<EmployeeContractorsModel> employeeContractors = employeeContractorsRepository.findAll();
		
		preDataDto.setReferrals(referrals);
		preDataDto.setSkills(skills);
		preDataDto.setRegion(region);
		preDataDto.setDepartment(department);
		preDataDto.setTimeZone(timeZone);
		preDataDto.setTerminationType(terminationType);
		preDataDto.setEmployeeContractors(employeeContractors);

		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, preDataDto);
		return response;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public StatusResponse getUserHrtInfo(long id) throws Exception {
		StatusResponse response = new StatusResponse();
		EmployeeModel hrtModel = employeeRepository.findById(id).orElse(null);
		EmployeeResponseDto responseDto = new EmployeeResponseDto();
		UserModel user = userRepository.findByeId(hrtModel.geteId());

		if (hrtModel != null) {
			responseDto.seteId(hrtModel.geteId());
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
			responseDto.setIsContractReceived(hrtModel.getIsContractReceived());
			responseDto.setIsHRRecievesContract(hrtModel.getIsHRRecievesContract());
			responseDto.setWorkCity(hrtModel.getWorkCity());
			responseDto.setWorkState(hrtModel.getWorkState());
			responseDto.setHoursWorkedPerDay(hrtModel.getHoursWorkedPerDay());
			responseDto.setNextReviewDate(hrtModel.getNextReviewDate());
			responseDto.setComments(hrtModel.getComments());
			responseDto.setCompanyName(hrtModel.getCompanyName());
			responseDto.setIsCompanyIsAllianceMember(hrtModel.getIsCompanyIsAllianceMember());
			responseDto.setFederalId(hrtModel.getFederalId());
			responseDto.setIsSubmissionGuidlineRecieved(hrtModel.getIsSubmissionGuidlineRecieved());
			responseDto.setRcgEmail(hrtModel.getRcgEmail());
			responseDto.setIsHiretoBeach(hrtModel.getIsHiretoBeach());
			responseDto.setIsRehiredEmployee(hrtModel.getIsRehiredEmployee());
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
			responseDto.setDepartment(hrtModel.getDepartment().getDepartmentName());
			responseDto.setRegion(hrtModel.getRegion().getRegionName());
			responseDto.setTimeZone(hrtModel.getTimeZone().getTimezoneName());
			responseDto.setTerminationDate(hrtModel.getTerminationDate());
			responseDto.setBloodGroup(hrtModel.getBloodGroup());
			responseDto.setQualification(hrtModel.getQualification());
			responseDto.setHomeAddress(hrtModel.getHomeAddress());
			responseDto.setRecruiter(hrtModel.getRecruiter());
			responseDto.setTaxId(hrtModel.getTaxId());
			responseDto.setTerminationType(hrtModel.getTerminationType().getValue());
			responseDto.setEmployeeContractors(hrtModel.getEmployeeContractors().getContractorName());
			if(user != null) {
				responseDto.setRole(user.getRole().getRoleId());
				responseDto.setUserName(user.getUserName());
				responseDto.setPassword(user.getPassword());
			}

			List<UserSkillResponseDto> skillDtoList = new ArrayList<UserSkillResponseDto>();
			List<EmployeeTechnologyModel> skilsList = userTechnologyRepository.findByEId(hrtModel.geteId());
			UserSkillResponseDto skillDto = new UserSkillResponseDto();
			skilsList.forEach((empSkills) -> {
				skillDto.setLevel(empSkills.getSkillLevel());
				skillDto.setSkill(empSkills.getSkills().getSkill());
				skillDtoList.add(skillDto);
			});
			responseDto.setUserSkills(skillDtoList);

			EmployeeReferralModel empReferral = userHrtReferralsRepository.findByEId(id);
			responseDto.setType(empReferral.getReferralsModel().getType());
			responseDto.setRecipient(empReferral.getReferralsModel().getRecipient());
			responseDto.setRefCode(empReferral.getReferralsModel().getRefCode());
			responseDto.setRefLimit(empReferral.getRefLimit());
			responseDto.setStartDate(empReferral.getStartDate());
			responseDto.setEndDate(empReferral.getEndDate());
			responseDto.setNotes(empReferral.getNotes());
			responseDto.setRatePerDay(empReferral.getRatePerDay());
			responseDto.setRatePerHour(empReferral.getRatePerHour());

		}
		response = new StatusResponse(Constants.SUCCESS, HttpStatus.OK, responseDto);

		return response;
	}

}
