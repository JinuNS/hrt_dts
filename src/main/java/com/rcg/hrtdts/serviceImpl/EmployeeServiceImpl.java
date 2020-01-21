package com.rcg.hrtdts.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.rcg.hrtdts.dto.PreDataDto;
import com.rcg.hrtdts.dto.EmployeeListDto;
import com.rcg.hrtdts.dto.EmployeeRequestDto;
import com.rcg.hrtdts.dto.EmployeeResponseDto;
import com.rcg.hrtdts.dto.UserSkillRequestDto;
import com.rcg.hrtdts.dto.UserSkillResponseDto;
import com.rcg.hrtdts.exception.HRTDTSException;
import com.rcg.hrtdts.model.EmployeeTypeModel;
import com.rcg.hrtdts.model.GenderModel;
import com.rcg.hrtdts.model.DepartmentModel;
import com.rcg.hrtdts.model.EmployeeContractorsModel;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.EmployeeReferralModel;
import com.rcg.hrtdts.model.EmployeeStatusModel;
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
import com.rcg.hrtdts.repository.EmployeeStatusRepository;
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
import com.rcg.hrtdts.utility.StringToDateConverter;

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
	
	@Autowired
	private EmployeeStatusRepository employeeStatusRepository;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@Transactional
	public String saveEmployeeInfo(EmployeeRequestDto requestDto) throws HRTDTSException,Exception {
		String response;
		EmployeeModel hrtModel = new EmployeeModel();
		if (requestDto.geteId() != null) {
			hrtModel = employeeRepository.findById(requestDto.geteId()).orElse(new EmployeeModel());
		}
		hrtModel.setFirstName(requestDto.getFirstName());
		hrtModel.setMiddleName(requestDto.getMiddleName());
		hrtModel.setLastName(requestDto.getLastName());
		hrtModel.setEmployeeNo(requestDto.getEmployeeNo());
		hrtModel.setPersonalEmail(requestDto.getPersonalEmail());
		hrtModel.setHiredate((requestDto.getHiredate() != null && !requestDto.getHiredate(). isEmpty())?StringToDateConverter.convertStringToDate(requestDto.getHiredate()):null);
		hrtModel.setDivision(requestDto.getDivision());
		hrtModel.setAssignmentBranch(requestDto.getAssignmentBranch());
		hrtModel.setTypeofAction(requestDto.getTypeofAction());
		hrtModel.setStreetAddress(requestDto.getStreetAddress());
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
		hrtModel.setNextReviewDate((requestDto.getNextReviewDate() != null && !requestDto.getNextReviewDate().isEmpty())?StringToDateConverter.convertStringToDate(requestDto.getNextReviewDate()):null);
		hrtModel.setComments(requestDto.getComments());
		hrtModel.setCompanyName(requestDto.getCompanyName());
		hrtModel.setIsCompanyIsAllianceMember(requestDto.getIsCompanyIsAllianceMember());
		hrtModel.setFederalId(requestDto.getFederalId());
		hrtModel.setIsSubmissionGuidlineRecieved(requestDto.getIsSubmissionGuidlineRecieved());
		hrtModel.setRcgEmail(requestDto.getRcgEmail());
		hrtModel.setIsHiretoBeach(requestDto.getIsHiretoBeach());
		hrtModel.setIsRehiredEmployee(requestDto.getIsRehiredEmployee());
		hrtModel.setSocialSecurityNumber(requestDto.getSocialSecurityNumber());
		hrtModel.setDob(((requestDto.getDob() != null && !requestDto.getDob().isEmpty()))?StringToDateConverter.convertStringToDate(requestDto.getDob()):null);
		hrtModel.setHireCodes(requestDto.getHireCodes());
		hrtModel.setHomeBranch(requestDto.getHomeBranch());
		hrtModel.setCPPCareerLevel(requestDto.getCPPCareerLevel());
		hrtModel.setTerminationDate(((requestDto.getTerminationDate() != null && !requestDto.getTerminationDate().isEmpty()))?StringToDateConverter.convertStringToDate(requestDto.getTerminationDate()):null);
		hrtModel.setBloodGroup(requestDto.getBloodGroup());
		hrtModel.setQualification(requestDto.getQualification());
		hrtModel.setHomeAddress(requestDto.getHomeAddress());
		hrtModel.setRecruiter(requestDto.getRecruiter());
		hrtModel.setTaxId(requestDto.getTaxId());
		hrtModel.setAnnualSalary(requestDto.getAnnualSalary());
		hrtModel.setCompanyCode(requestDto.getCompanyCode());

		if(requestDto.getEmployeeStatusId() != null) {
			EmployeeStatusModel employeeStatus = employeeStatusRepository.findById(requestDto.getEmployeeStatusId()).orElse(null);
			hrtModel.setEmployeeStatus(employeeStatus);
		}
		if (requestDto.getDepartmentId() != null) {
			DepartmentModel department = departmentRepository.findById(requestDto.getDepartmentId()).orElse(null);
			hrtModel.setDepartment(department);
		}
		if (requestDto.getRegionId() != null) {
			RegionModel region = regionRepository.findById(requestDto.getRegionId()).orElse(null);
			hrtModel.setRegion(region);
		}
		if (requestDto.getTimeZoneId() != null) {
			TimeZoneModel timezone = timeZoneRepository.findById(requestDto.getTimeZoneId()).orElse(null);
			hrtModel.setTimeZone(timezone);
		}
		if (requestDto.getEmployeeContractorsId() != null) {
			EmployeeContractorsModel vendor = employeeContractorsRepository
					.findById(requestDto.getEmployeeContractorsId()).orElse(null);
			hrtModel.setEmployeeContractors(vendor);
		}
		if (requestDto.getTerminationTypeId() != null) {
			TerminationTypeModel terminationType = terminationTypeRepository.findById(requestDto.getTerminationTypeId())
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
		Boolean isSkillsExists = userTechnologyRepository.existsByEId(hrtModel.geteId());
		if (isSkillsExists) {
			userTechnologyRepository.deleteByUserHrtModelEId(hrtModel.geteId());
		}
		saveUserhrtSkills(hrtModel, requestDto);

		// saving userHrtReferrals
		Boolean isReferralsExists = userHrtReferralsRepository.existsByEId(hrtModel.geteId());
		if (isReferralsExists) {
			userHrtReferralsRepository.deleteByUserHrtModelEId(hrtModel.geteId());
		}
		saveUserHrtReferrals(hrtModel, requestDto);

		// saving employeeCredentials
		saveEmployeeCredentials(hrtModel, requestDto);

		response = "Successfully saved";
		return response;
	}

	private void saveEmployeeCredentials(EmployeeModel hrtModel, EmployeeRequestDto requestDto) {

		UserModel user = new UserModel();
		Boolean isUserNameExists = false;
		
		Boolean isUserExists = userRepository.existsByEId(hrtModel.geteId());
		if (isUserExists) {
			user = userRepository.findByeId(hrtModel.geteId());
			isUserNameExists = userRepository.existsByuserNameAndEId(requestDto.getUserName(),hrtModel.geteId());
			
		}else {
			isUserNameExists = userRepository.existsByuserName(requestDto.getUserName());

		}
		if(isUserNameExists) {
			throw new HRTDTSException("Username alreary extst.");
		}

		

		user.setEmployee(hrtModel);
		user.setEmail(hrtModel.getRcgEmail());
		if (requestDto.getRoleId() != null) {
			RoleModel role = roleRepository.findById(requestDto.getRoleId()).orElse(null);
			user.setRole(role);
		}
		user.setUserName(requestDto.getUserName());
		user.setPassword(requestDto.getPassword());
		user.setIsActive(requestDto.getIsActive());
		
		userRepository.save(user);
	}

	private void saveUserHrtReferrals(EmployeeModel hrtModel, EmployeeRequestDto requestDto) throws ParseException {

		if (requestDto.getReferralId() != null) {
			EmployeeReferralModel userHrtReferralModel = new EmployeeReferralModel();
			ReferralsModel referralsModel = referralsRepository.findByReferralId(requestDto.getReferralId());
			userHrtReferralModel.setReferralsModel(referralsModel);
			userHrtReferralModel.setUserHrtModel(hrtModel);
			userHrtReferralModel.setEndDate((requestDto.getEndDate() != null && !requestDto.getEndDate().isEmpty())?StringToDateConverter.convertStringToDate(requestDto.getEndDate()):null);
			userHrtReferralModel.setNotes(requestDto.getNotes());
			userHrtReferralModel.setRatePerDay(requestDto.getRatePerDay());
			userHrtReferralModel.setRatePerHour(requestDto.getRatePerHour());
			userHrtReferralModel.setRefLimit(requestDto.getRefLimit());
			userHrtReferralModel.setStartDate((requestDto.getStartDate() != null && !requestDto.getStartDate().isEmpty())?StringToDateConverter.convertStringToDate(requestDto.getStartDate()):null);
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
				userSkillModel.setExperience(dto.getExperiance());
				userSkillModelList.add(userSkillModel);
			}
			userTechnologyRepository.saveAll(userSkillModelList);
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public PreDataDto getSkillsAndReferrals() throws Exception {
		PreDataDto preDataDto = new PreDataDto();
		List<TechnologyModel> skills = technologyRepository.findAll();
		List<ReferralsModel> referrals = referralsRepository.findAll();
		List<RegionModel> region = regionRepository.findAll();
		List<DepartmentModel> department = departmentRepository.findAll();
		List<TimeZoneModel> timeZone = timeZoneRepository.findAll();
		List<TerminationTypeModel> terminationType = terminationTypeRepository.findAll();
		List<EmployeeContractorsModel> employeeContractors = employeeContractorsRepository.findAll();
		List<EmployeeStatusModel> employeeStatus = employeeStatusRepository.findAll();
		List<MaritalStatusModel> maritalStatus = maritalStatusRepository.findAll();
		List<EmployeeTypeModel> employeeType = employeeTypeRepository.findAll();
		List<RaceModel> race = raceRepository.findAll();
		List<RoleModel> role = roleRepository.findAll();
		
		preDataDto.setReferrals(referrals);
		preDataDto.setSkills(skills);
		preDataDto.setRegion(region);
		preDataDto.setDepartment(department);
		preDataDto.setTimeZone(timeZone);
		preDataDto.setTerminationType(terminationType);
		preDataDto.setEmployeeContractors(employeeContractors);
		preDataDto.setEmployeeStatus(employeeStatus);
		preDataDto.setMaritalStatus(maritalStatus);
		preDataDto.setEmployeeType(employeeType);
		preDataDto.setRace(race);
		preDataDto.setRole(role);

		return preDataDto;
	}

	@SuppressWarnings({ "rawtypes", "unchecked", "unused" })
	@Override
	public EmployeeResponseDto getUserHrtInfo(long id) throws Exception {
		EmployeeModel hrtModel = employeeRepository.findById(id).orElse(null);
		EmployeeResponseDto responseDto = null;
		if (hrtModel != null) {
			responseDto = new EmployeeResponseDto();
		    UserModel user = userRepository.findByeId(hrtModel.geteId());
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
			responseDto.setStreetAddress(hrtModel.getStreetAddress());
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
			responseDto.setEmployeeType((hrtModel.getEmployeeType() != null)?hrtModel.getEmployeeType().getValue():null);
			responseDto.setGender((hrtModel.getGender() != null)?hrtModel.getGender().getValue():null);
			responseDto.setJobType((hrtModel.getJobType() != null)?hrtModel.getJobType().getValue():null);
			responseDto.setMaritalStatus((hrtModel.getMaritalStatus() != null)?hrtModel.getMaritalStatus().getValue():null);
			responseDto.setRace((hrtModel.getRace() != null)?hrtModel.getRace().getValue():null);
			responseDto.setDepartment((hrtModel.getDepartment() != null)?hrtModel.getDepartment().getDepartmentId():null);
			responseDto.setRegion((hrtModel.getRegion() != null)?hrtModel.getRegion().getId():null);
			responseDto.setTimeZone((hrtModel.getTimeZone() != null)?hrtModel.getTimeZone().getId():null);
			responseDto.setTerminationDate(hrtModel.getTerminationDate());
			responseDto.setBloodGroup(hrtModel.getBloodGroup());
			responseDto.setQualification(hrtModel.getQualification());
			responseDto.setHomeAddress(hrtModel.getHomeAddress());
			responseDto.setRecruiter(hrtModel.getRecruiter());
			responseDto.setTaxId(hrtModel.getTaxId());
			responseDto.setTerminationType((hrtModel.getTerminationType() != null)?hrtModel.getTerminationType().getId():null);
			responseDto.setEmployeeContractors((hrtModel.getEmployeeContractors() != null)?hrtModel.getEmployeeContractors().getContractorId():null);
			responseDto.setEmployeeStatus((hrtModel.getEmployeeStatus() != null)?hrtModel.getEmployeeStatus().getId():null);
			responseDto.setAnnualSalary(hrtModel.getAnnualSalary());
			responseDto.setCompanyCode(hrtModel.getCompanyCode());
			if(user != null) {
				responseDto.setRole((user.getRole() != null)?user.getRole().getRoleId():null);
				responseDto.setUserName(user.getUserName());
				responseDto.setPassword(user.getPassword());
				responseDto.setIsActive(user.getIsActive());
			}

			List<UserSkillResponseDto> skillDtoList = new ArrayList<UserSkillResponseDto>();
			List<EmployeeTechnologyModel> skilsList = userTechnologyRepository.findByEId(hrtModel.geteId());
			if(skilsList != null) {
			        skilsList.forEach((empSkills) -> { if(empSkills != null) {
					UserSkillResponseDto skillDto = new UserSkillResponseDto();
					skillDto.setLevel(empSkills.getSkillLevel());
					skillDto.setSkill((empSkills.getSkills() != null)?empSkills.getSkills().getSkill():null);
					skillDto.setExperiance(empSkills.getExperience());
					skillDto.setComment(empSkills.getComment());
					skillDto.setSkillId(empSkills.getSkills().getId());
					skillDtoList.add(skillDto);
				}
					
				});
				responseDto.setUserSkills(skillDtoList);
			}
			

			EmployeeReferralModel empReferral = userHrtReferralsRepository.findByEId(id);
			if(empReferral != null) {
				responseDto.setType((empReferral.getReferralsModel() != null)?empReferral.getReferralsModel().getType():null);
				responseDto.setRecipient((empReferral.getReferralsModel() != null)?empReferral.getReferralsModel().getRecipient():null);
				responseDto.setRecipientId((empReferral.getReferralsModel() != null)?empReferral.getReferralsModel().getId():null);
				responseDto.setRefCode((empReferral.getReferralsModel() != null)?empReferral.getReferralsModel().getRefCode():null);
				responseDto.setRefLimit(empReferral.getRefLimit());
				responseDto.setStartDate(empReferral.getStartDate());
				responseDto.setEndDate(empReferral.getEndDate());
				responseDto.setNotes(empReferral.getNotes());
				responseDto.setRatePerDay(empReferral.getRatePerDay());
				responseDto.setRatePerHour(empReferral.getRatePerHour());
			}
			

		}

		if(responseDto == null)
			throw new HRTDTSException("Employee info is not available for this ID");
		
		return responseDto;
	}


	@Override
	public EmployeeModel getUserDetailsById(Long id) {
		return employeeRepository.getNonActiveUser(id);
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public List<EmployeeListDto> getEmployeeList() throws Exception {

		List<EmployeeListDto> responseList = new ArrayList<EmployeeListDto>();
		List<Object[]> employeeList = userRepository.getEmployeeLists();
		employeeList.forEach(result -> {
		   EmployeeListDto responseDto = new EmployeeListDto();
		   responseDto.seteId((result[0] != null)?Long.parseLong(result[0].toString()):null);
		   responseDto.setFirstName((result[2] != null)?(String) result[2]:null);
		   responseDto.setLastName((result[3] != null)?(String) result[3]:null);
		   responseDto.setJobType((result[4] != null)?(String) result[4]:null);
		   responseDto.setUserName((result[1] != null)?(String) result[1]:null);
		   responseDto.setDepartment((result[5] != null)?(String) result[5]:null);
		   responseDto.setHireDate((result[6] != null)?(Date) result[6]:null);
		   responseDto.setCppLevel((result[7] != null)?(String) result[7]:null);
		   responseDto.setStatus((result[8] != null)?(String) result[8]:null);
		   responseDto.setConsultantType((result[9] != null)?(String) result[9]:null);

		   responseList.add(responseDto);});	
		
		return responseList;
	}


}
