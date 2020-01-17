package com.rcg.hrtdts.repository;

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
}
