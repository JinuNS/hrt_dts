package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.EmployeeModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeRepository extends JpaRepository<EmployeeModel, Long>{
	
	@Query("SELECT e FROM EmployeeModel e WHERE e.eId = ?1")
	EmployeeModel getNonActiveUser(Long id);
	
	@Query("SELECT u FROM EmployeeModel u WHERE u.role in (11,8)")
	List<EmployeeModel> getProjectOwners();

	@Query("SELECT u FROM EmployeeModel u WHERE u.role in (11,8)")
	List<EmployeeModel> getOnsiteLeads();
}
