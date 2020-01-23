package com.rcg.hrtdts.serviceImpl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	@Transactional
	public String saveEmployeeInfo(EmployeeRequestDto requestDto) throws HRTDTSException, Exception {
		String response;
		EmployeeModel employeeModel = new EmployeeModel();
		if (requestDto.geteId() != null) {
			employeeModel = employeeRepository.findById(requestDto.geteId()).orElse(new EmployeeModel());
		}
		employeeModel.setFirstName(requestDto.getFirstName());
		employeeModel.setMiddleName(requestDto.getMiddleName());
		employeeModel.setLastName(requestDto.getLastName());
		employeeModel.setEmployeeNo(requestDto.getEmployeeNo());
		employeeModel.setPersonalEmail(requestDto.getPersonalEmail());
		employeeModel.setHiredate((requestDto.getHiredate() != null && !requestDto.getHiredate().isEmpty())
				? StringToDateConverter.convertStringToDate(requestDto.getHiredate())
				: null);
		employeeModel.setDivision(requestDto.getDivision());
		employeeModel.setAssignmentBranch(requestDto.getAssignmentBranch());
		employeeModel.setTypeofAction(requestDto.getTypeofAction());
		employeeModel.setStreetAddress(requestDto.getStreetAddress());
		employeeModel.setApt(requestDto.getApt());
		employeeModel.setCity(requestDto.getCity());
		employeeModel.setStateorCountry(requestDto.getStateorCountry());
		employeeModel.setZip(requestDto.getZip());
		employeeModel.setHomePhone(requestDto.getHomePhone());
		employeeModel.setBusinessPhone(requestDto.getBusinessPhone());
		employeeModel.setHourlySalary(requestDto.getHourlySalary());
		employeeModel.setOvertimeSalary(requestDto.getOvertimeSalary());
		employeeModel.setFixedRatePay(requestDto.getFixedRatePay());
		employeeModel.setDailyPayRate(requestDto.getDailyPayRate());
		employeeModel.setPerdiemAllowence(requestDto.getPerdiemAllowence());
		employeeModel.setIsContractReceived(requestDto.getIsContractReceived());
		employeeModel.setIsHRRecievesContract(requestDto.getIsHRRecievesContract());
		employeeModel.setWorkCity(requestDto.getWorkCity());
		employeeModel.setWorkState(requestDto.getWorkState());
		employeeModel.setHoursWorkedPerDay(requestDto.getHoursWorkedPerDay());
		employeeModel.setNextReviewDate((requestDto.getNextReviewDate() != null && !requestDto.getNextReviewDate().isEmpty())
				? StringToDateConverter.convertStringToDate(requestDto.getNextReviewDate())
				: null);
		employeeModel.setComments(requestDto.getComments());
		employeeModel.setCompanyName(requestDto.getCompanyName());
		employeeModel.setIsCompanyIsAllianceMember(requestDto.getIsCompanyIsAllianceMember());
		employeeModel.setFederalId(requestDto.getFederalId());
		employeeModel.setIsSubmissionGuidlineRecieved(requestDto.getIsSubmissionGuidlineRecieved());
		employeeModel.setRcgEmail(requestDto.getRcgEmail());
		employeeModel.setIsHiretoBeach(requestDto.getIsHiretoBeach());
		employeeModel.setIsRehiredEmployee(requestDto.getIsRehiredEmployee());
		employeeModel.setSocialSecurityNumber(requestDto.getSocialSecurityNumber());
		employeeModel.setDob(((requestDto.getDob() != null && !requestDto.getDob().isEmpty()))
				? StringToDateConverter.convertStringToDate(requestDto.getDob())
				: null);
		employeeModel.setHireCodes(requestDto.getHireCodes());
		employeeModel.setHomeBranch(requestDto.getHomeBranch());
		employeeModel.setCPPCareerLevel(requestDto.getCPPCareerLevel());
		employeeModel.setTerminationDate(
				((requestDto.getTerminationDate() != null && !requestDto.getTerminationDate().isEmpty()))
						? StringToDateConverter.convertStringToDate(requestDto.getTerminationDate())
						: null);
		employeeModel.setBloodGroup(requestDto.getBloodGroup());
		employeeModel.setQualification(requestDto.getQualification());
		employeeModel.setHomeAddress(requestDto.getHomeAddress());
		employeeModel.setRecruiter(requestDto.getRecruiter());
		employeeModel.setTaxId(requestDto.getTaxId());
		employeeModel.setAnnualSalary(requestDto.getAnnualSalary());
		employeeModel.setCompanyCode(requestDto.getCompanyCode());

		if (requestDto.getEmployeeStatusId() != null) {
			EmployeeStatusModel employeeStatus = employeeStatusRepository.findById(requestDto.getEmployeeStatusId())
					.orElse(null);
			employeeModel.setEmployeeStatus(employeeStatus);
		}
		if (requestDto.getDepartmentId() != null) {
			DepartmentModel department = departmentRepository.findById(requestDto.getDepartmentId()).orElse(null);
			employeeModel.setDepartment(department);
		}
		if (requestDto.getRegionId() != null) {
			RegionModel region = regionRepository.findById(requestDto.getRegionId()).orElse(null);
			employeeModel.setRegion(region);
		}
		if (requestDto.getTimeZoneId() != null) {
			TimeZoneModel timezone = timeZoneRepository.findById(requestDto.getTimeZoneId()).orElse(null);
			employeeModel.setTimeZone(timezone);
		}
		if (requestDto.getEmployeeContractorsId() != null) {
			EmployeeContractorsModel vendor = employeeContractorsRepository
					.findById(requestDto.getEmployeeContractorsId()).orElse(null);
			employeeModel.setEmployeeContractors(vendor);
		}
		if (requestDto.getTerminationTypeId() != null) {
			TerminationTypeModel terminationType = terminationTypeRepository.findById(requestDto.getTerminationTypeId())
					.orElse(null);
			employeeModel.setTerminationType(terminationType);
		}
		if (requestDto.getEmployeeType() != null) {
			EmployeeTypeModel employeeType = employeeTypeRepository.findByValue(requestDto.getEmployeeType());
			employeeModel.setEmployeeType(employeeType);
		}
		if (requestDto.getGender() != null) {
			GenderModel gender = genderRepository.findByValue(requestDto.getGender());
			employeeModel.setGender(gender);
		}
		if (requestDto.getJobType() != null) {
			JobTypeModel jobType = jobTypeRepository.findByValue(requestDto.getJobType());
			employeeModel.setJobType(jobType);
		}
		if (requestDto.getMaritalStatus() != null) {
			MaritalStatusModel maritalStatus = maritalStatusRepository.findByValue(requestDto.getMaritalStatus());
			employeeModel.setMaritalStatus(maritalStatus);
		}
		if (requestDto.getRace() != null) {
			RaceModel race = raceRepository.findByValue(requestDto.getRace());
			employeeModel.setRace(race);
		}

		employeeRepository.save(employeeModel);

		// saving user skills
		Boolean isSkillsExists = userTechnologyRepository.existsByEId(employeeModel.geteId());
		if (isSkillsExists) {
			userTechnologyRepository.deleteByUserHrtModelEId(employeeModel.geteId());
		}
		saveUserhrtSkills(employeeModel, requestDto);

		// saving userHrtReferrals
		Boolean isReferralsExists = userHrtReferralsRepository.existsByEId(employeeModel.geteId());
		if (isReferralsExists) {
			userHrtReferralsRepository.deleteByUserHrtModelEId(employeeModel.geteId());
		}
		saveUserHrtReferrals(employeeModel, requestDto);

		// saving employeeCredentials
		saveEmployeeCredentials(employeeModel, requestDto);

		response = "Successfully saved";
		return response;
	}

	private void saveEmployeeCredentials(EmployeeModel employeeModel, EmployeeRequestDto requestDto) {

		UserModel user = new UserModel();
		Boolean isUserNameExists = false;

		Boolean isUserExists = userRepository.existsByEId(employeeModel.geteId());
		if (isUserExists) {
			user = userRepository.findByeId(employeeModel.geteId());
			isUserNameExists = userRepository.existsByuserNameAndEId(requestDto.getUserName(), employeeModel.geteId());

		} else {
			isUserNameExists = userRepository.existsByuserName(requestDto.getUserName());

		}
		if (isUserNameExists) {
			throw new HRTDTSException("Username alreary extst.");
		}

		user.setEmployee(employeeModel);
		user.setEmail(employeeModel.getRcgEmail());
		if (requestDto.getRoleId() != null) {
			RoleModel role = roleRepository.findById(requestDto.getRoleId()).orElse(null);
			user.setRole(role);
		}
		user.setUserName(requestDto.getUserName());
		user.setPassword(requestDto.getPassword());
		user.setIsActive(requestDto.getIsActive());

		userRepository.save(user);
	}

	private void saveUserHrtReferrals(EmployeeModel employeeModel, EmployeeRequestDto requestDto) throws ParseException {

		if (requestDto.getReferralId() != null) {
			EmployeeReferralModel userHrtReferralModel = new EmployeeReferralModel();
			ReferralsModel referralsModel = referralsRepository.findById(requestDto.getReferralId()).orElse(null);
			if(referralsModel != null) {
				userHrtReferralModel.setReferralsModel(referralsModel);
				userHrtReferralModel.setEmployeeModel(employeeModel);
				userHrtReferralModel.setEndDate((requestDto.getEndDate() != null && !requestDto.getEndDate().isEmpty())
						? StringToDateConverter.convertStringToDate(requestDto.getEndDate())
						: null);
				userHrtReferralModel.setNotes(requestDto.getNotes());
				userHrtReferralModel.setRatePerDay(requestDto.getRatePerDay());
				userHrtReferralModel.setRatePerHour(requestDto.getRatePerHour());
				userHrtReferralModel.setRefLimit(requestDto.getRefLimit());
				userHrtReferralModel
						.setStartDate((requestDto.getStartDate() != null && !requestDto.getStartDate().isEmpty())
								? StringToDateConverter.convertStringToDate(requestDto.getStartDate())
								: null);
				userHrtReferralsRepository.save(userHrtReferralModel);
			}
			
		}

	}

	private void saveUserhrtSkills(EmployeeModel employeeModel, EmployeeRequestDto requestDto) {

		List<EmployeeTechnologyModel> userSkillModelList = new ArrayList<EmployeeTechnologyModel>();
		if (requestDto.getUserSkills() != null && requestDto.getUserSkills().size() > 0) {
			List<UserSkillRequestDto> skills = requestDto.getUserSkills();
			if(skills != null && skills.size() > 0) {
				for (UserSkillRequestDto dto : skills) {
					EmployeeTechnologyModel userSkillModel = new EmployeeTechnologyModel();
					userSkillModel.setEmployeeModel(employeeModel);
					TechnologyModel skillsModel = technologyRepository.findById(dto.getSkillId())
							.orElse(new TechnologyModel());
					userSkillModel.setSkills(skillsModel);
					userSkillModel.setSkillLevel(dto.getLevel());
					userSkillModel.setExperience(dto.getExperiance());
					userSkillModelList.add(userSkillModel);
				}
				userTechnologyRepository.saveAll(userSkillModelList);
			}
		}

	}

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
		List<JobTypeModel> jobType = jobTypeRepository.findAll();

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
		preDataDto.setJobType(jobType);

		return preDataDto;
	}

	@Override
	public EmployeeResponseDto getUserHrtInfo(long id)  throws HRTDTSException, Exception {
		EmployeeModel employeeModel = employeeRepository.findById(id).orElse(null);
		EmployeeResponseDto responseDto = null;
		if (employeeModel != null) {
			responseDto = new EmployeeResponseDto();
			UserModel user = userRepository.findByeId(employeeModel.geteId());
			responseDto.seteId(employeeModel.geteId());
			responseDto.setFirstName(employeeModel.getFirstName());
			responseDto.setMiddleName(employeeModel.getMiddleName());
			responseDto.setLastName(employeeModel.getLastName());
			responseDto.setEmployeeNo(employeeModel.getEmployeeNo());
			responseDto.setPersonalEmail(employeeModel.getPersonalEmail());
			responseDto.setHiredate(employeeModel.getHiredate());
			responseDto.setDivision(employeeModel.getDivision());
			responseDto.setAssignmentBranch(employeeModel.getAssignmentBranch());
			responseDto.setTypeofAction(employeeModel.getTypeofAction());
			responseDto.setStreetAddress(employeeModel.getStreetAddress());
			responseDto.setApt(employeeModel.getApt());
			responseDto.setCity(employeeModel.getCity());
			responseDto.setStateorCountry(employeeModel.getStateorCountry());
			responseDto.setZip(employeeModel.getZip());
			responseDto.setHomePhone(employeeModel.getHomePhone());
			responseDto.setBusinessPhone(employeeModel.getBusinessPhone());
			responseDto.setHourlySalary(employeeModel.getHourlySalary());
			responseDto.setOvertimeSalary(employeeModel.getOvertimeSalary());
			responseDto.setFixedRatePay(employeeModel.getFixedRatePay());
			responseDto.setDailyPayRate(employeeModel.getDailyPayRate());
			responseDto.setPerdiemAllowence(employeeModel.getPerdiemAllowence());
			responseDto.setIsContractReceived(employeeModel.getIsContractReceived());
			responseDto.setIsHRRecievesContract(employeeModel.getIsHRRecievesContract());
			responseDto.setWorkCity(employeeModel.getWorkCity());
			responseDto.setWorkState(employeeModel.getWorkState());
			responseDto.setHoursWorkedPerDay(employeeModel.getHoursWorkedPerDay());
			responseDto.setNextReviewDate(employeeModel.getNextReviewDate());
			responseDto.setComments(employeeModel.getComments());
			responseDto.setCompanyName(employeeModel.getCompanyName());
			responseDto.setIsCompanyIsAllianceMember(employeeModel.getIsCompanyIsAllianceMember());
			responseDto.setFederalId(employeeModel.getFederalId());
			responseDto.setIsSubmissionGuidlineRecieved(employeeModel.getIsSubmissionGuidlineRecieved());
			responseDto.setRcgEmail(employeeModel.getRcgEmail());
			responseDto.setIsHiretoBeach(employeeModel.getIsHiretoBeach());
			responseDto.setIsRehiredEmployee(employeeModel.getIsRehiredEmployee());
			responseDto.setSocialSecurityNumber(employeeModel.getSocialSecurityNumber());
			responseDto.setDob(employeeModel.getDob());
			responseDto.setHireCodes(employeeModel.getHireCodes());
			responseDto.setHomeBranch(employeeModel.getHomeBranch());
			responseDto.setCppLevel(employeeModel.getCPPCareerLevel());
			responseDto.setEmployeeType(
					(employeeModel.getEmployeeType() != null) ? employeeModel.getEmployeeType().getValue() : null);
			responseDto.setGender((employeeModel.getGender() != null) ? employeeModel.getGender().getValue() : null);
			responseDto.setJobType((employeeModel.getJobType() != null) ? employeeModel.getJobType().getValue() : null);
			responseDto.setMaritalStatus(
					(employeeModel.getMaritalStatus() != null) ? employeeModel.getMaritalStatus().getValue() : null);
			responseDto.setRace((employeeModel.getRace() != null) ? employeeModel.getRace().getValue() : null);
			responseDto.setDepartment(
					(employeeModel.getDepartment() != null) ? employeeModel.getDepartment().getDepartmentId() : null);
			responseDto.setRegion((employeeModel.getRegion() != null) ? employeeModel.getRegion().getId() : null);
			responseDto.setTimeZone((employeeModel.getTimeZone() != null) ? employeeModel.getTimeZone().getId() : null);
			responseDto.setTerminationDate(employeeModel.getTerminationDate());
			responseDto.setBloodGroup(employeeModel.getBloodGroup());
			responseDto.setQualification(employeeModel.getQualification());
			responseDto.setHomeAddress(employeeModel.getHomeAddress());
			responseDto.setRecruiter(employeeModel.getRecruiter());
			responseDto.setTaxId(employeeModel.getTaxId());
			responseDto.setTerminationType(
					(employeeModel.getTerminationType() != null) ? employeeModel.getTerminationType().getId() : null);
			responseDto.setEmployeeContractors(
					(employeeModel.getEmployeeContractors() != null) ? employeeModel.getEmployeeContractors().getContractorId()
							: null);
			responseDto.setEmployeeStatus(
					(employeeModel.getEmployeeStatus() != null) ? employeeModel.getEmployeeStatus().getId() : null);
			responseDto.setAnnualSalary(employeeModel.getAnnualSalary());
			responseDto.setCompanyCode(employeeModel.getCompanyCode());
			if (user != null) {
				responseDto.setRole((user.getRole() != null) ? user.getRole().getRoleId() : null);
				responseDto.setUserName(user.getUserName());
				responseDto.setPassword(user.getPassword());
				responseDto.setIsActive(user.getIsActive());
			}

			List<UserSkillResponseDto> skillDtoList = new ArrayList<UserSkillResponseDto>();
			List<EmployeeTechnologyModel> skilsList = userTechnologyRepository.findByEId(employeeModel.geteId());
			if (skilsList != null) {
				skilsList.forEach((empSkills) -> {
					if (empSkills != null) {
						UserSkillResponseDto skillDto = new UserSkillResponseDto();
						skillDto.setLevel(empSkills.getSkillLevel());
						skillDto.setSkill((empSkills.getSkills() != null) ? empSkills.getSkills().getSkill() : null);
						skillDto.setExperiance(empSkills.getExperience());
						skillDto.setComment(empSkills.getComment());
						skillDto.setSkillId(empSkills.getSkills().getId());
						skillDtoList.add(skillDto);
					}

				});
				responseDto.setUserSkills(skillDtoList);
			}

			EmployeeReferralModel empReferral = userHrtReferralsRepository.findByEId(id);
			if (empReferral != null) {
				responseDto.setType(
						(empReferral.getReferralsModel() != null) ? empReferral.getReferralsModel().getType() : null);
				responseDto.setRecipient(
						(empReferral.getReferralsModel() != null) ? empReferral.getReferralsModel().getRecipient()
								: null);
				responseDto.setRecipientId(
						(empReferral.getReferralsModel() != null) ? empReferral.getReferralsModel().getId() : null);
				responseDto.setRefCode(
						(empReferral.getReferralsModel() != null) ? empReferral.getReferralsModel().getRefCode()
								: null);
				responseDto.setRefLimit(empReferral.getRefLimit());
				responseDto.setStartDate(empReferral.getStartDate());
				responseDto.setEndDate(empReferral.getEndDate());
				responseDto.setNotes(empReferral.getNotes());
				responseDto.setRatePerDay(empReferral.getRatePerDay());
				responseDto.setRatePerHour(empReferral.getRatePerHour());
			}

		}

		if (responseDto == null)
			throw new HRTDTSException("Employee info is not available for this ID");

		return responseDto;
	}

	@Override
	public EmployeeModel getUserDetailsById(Long id) {
		return employeeRepository.getNonActiveUser(id);
	}

	@Override
	public List<EmployeeListDto> getEmployeeList() throws Exception {

		List<EmployeeListDto> responseList = new ArrayList<EmployeeListDto>();
		List<Object[]> employeeList = userRepository.getEmployeeLists();
		if(employeeList != null && employeeList.size() > 0) {
			employeeList.forEach(result -> {
				EmployeeListDto responseDto = new EmployeeListDto();
				responseDto.seteId((result[0] != null) ? Long.parseLong(result[0].toString()) : null);
				responseDto.setFirstName((result[2] != null) ? (String) result[2] : null);
				responseDto.setLastName((result[3] != null) ? (String) result[3] : null);
				responseDto.setJobType((result[4] != null) ? (String) result[4] : null);
				responseDto.setUserName((result[1] != null) ? (String) result[1] : null);
				responseDto.setDepartment((result[5] != null) ? (String) result[5] : null);
				responseDto.setHireDate((result[6] != null) ? (Date) result[6] : null);
				responseDto.setCppLevel((result[7] != null) ? (String) result[7] : null);
				responseDto.setStatus((result[8] != null) ? (String) result[8] : null);
				responseDto.setConsultantType((result[9] != null) ? (String) result[9] : null);

				responseList.add(responseDto);
			});
		}
		return responseList;
	}

}
