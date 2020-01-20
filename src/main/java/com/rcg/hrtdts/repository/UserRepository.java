package com.rcg.hrtdts.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rcg.hrtdts.dto.EmployeeListDto;
import com.rcg.hrtdts.model.UserModel;
/**
 * 
 * @author  charly
 * @version 1.0
 * @since   2020-01-16 
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

	@Query("select new com.rcg.hrtdts.dto.EmployeeListDto( u.employee.firstName,u.employee.lastName,u.userName,u.employee.jobType.value,u.employee.department.departmentName,u.employee.CPPCareerLevel,u.employee.hiredate) from UserModel u")
	List<EmployeeListDto> getEmployeeLists();

	Boolean existsByuserName(String userName);

	@Query("select u.userId,u.employee.firstName,u.employee.lastName from UserModel u WHERE u.role.roleName = 'Approver' ")
	ArrayList<Object[]> getAllProjectManagers();


}
