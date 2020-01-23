package com.rcg.hrtdts.repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rcg.hrtdts.dto.EmployeeListDto;
import com.rcg.hrtdts.model.EmployeeModel;
import com.rcg.hrtdts.model.UserModel;

/**
 * 
 * @author charly
 * @version 1.0
 * @since 2020-01-16
 * 
 **/
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

	UserModel findByuserName(String username);

	@Query("select count(*) > 0 from UserModel u where u.employee.eId = ?1")
	Boolean existsByEId(Long geteId);

	@Query("select u from UserModel u where u.employee.eId = ?1")
	UserModel findByeId(Long geteId);

	@Query("SELECT u FROM UserModel u WHERE u.role in (4)")
	List<UserModel> getProjectOwners();

	@Query("SELECT u FROM UserModel u WHERE u.role in (4)")
	List<UserModel> getOnsiteLeads();

	@Query("SELECT e FROM UserModel e WHERE e.employee.eId = ?1")
	UserModel getNonActiveUser(Long id);

//	@Query("select new com.rcg.hrtdts.dto.EmployeeListDto(u.employee.eId,u.employee.firstName,u.employee.lastName,u.userName,u.employee.jobType.value,u.employee.department.departmentName,u.employee.CPPCareerLevel,u.employee.hiredate) from UserModel u")
	@Query(value = "select e.eId,u.userName,e.firstName,e.lastName,j.value,d.departmentName,e.hiredate,e.CPPCareerLevel,s.value AS Status,t.value AS consultantType from UserModel u left join EmployeeModel e on u.employee_eId = e.eId left join JobTypeModel j on e.jobType_id = j.id left join DepartmentModel d on d.departmentId = e.department_departmentId left join EmployeeStatusModel s on s.id = e.employeeStatus_id left join EmployeeTypeModel t on t.id = e.employeeType_id", nativeQuery = true)
	List<Object[]> getEmployeeLists();

	Boolean existsByuserName(String userName);

	@Query("select u.userId,u.employee.firstName,u.employee.lastName from UserModel u WHERE u.role.roleId = 4 ")
	ArrayList<Object[]> getAllProjectManagers();

	@Query("select count(*) > 0 from UserModel u where u.userName = ?1 and u.employee.eId != ?2")
	Boolean existsByuserNameAndEId(String userName, Long eId);

	@Query("SELECT u FROM UserModel u WHERE u.region.id = ?1 AND u.isActive = true AND u.role.roleId not in('1') and department.departmentId not in('5','6','7','11') order by u.employee.firstName")
	List<UserModel> getUserlistByregionAndDepartment(Long regionId);

	@Query("SELECT u FROM UserModel u WHERE u.department.departmentId= ?1 AND u.isActive = true AND u.role.roleId = 3 order by u.employee.firstName")
	List<UserModel> getUserByDeptId(Long deptId);

	@Query("SELECT u FROM UserModel u WHERE  u.role.roleId in('2','3','5','11','9') and  department.departmentId in('1','2','3','4','8') and region.id = ?3 and (terminationDate >= ?1 or terminationDate IS NULL) and joiningDate<=?2 order by u.employee.firstName")
	List<UserModel> getUserByRegion(Date startDate, Date endDate, Long regionId);

	@Query("SELECT u FROM UserModel u WHERE u.userId= ?1 and u.department.departmentId = ?2 AND u.isActive = true order by u.employee.firstName")
	UserModel getUser(Long userId, Long deptId);

	@Query("SELECT u FROM UserModel u WHERE u.userId = ?2 and u.region.id = ?1  AND u.isActive = true order by u.employee.firstName")
	UserModel getUserByRegion(Long regionId, Long userId);

	@Query("SELECT u FROM UserModel u WHERE u.userId = ?1 and u.department.departmentId = ?2  and u.region.id = ?3 AND u.isActive = true order by u.employee.firstName")
	UserModel getUserBydeptRegion(Long deptId, Long userId, Long regionId);

}
