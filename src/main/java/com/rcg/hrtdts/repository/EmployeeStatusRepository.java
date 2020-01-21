package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.EmployeeStatusModel;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatusModel, Long>{

	EmployeeStatusModel findByValue(String employeeType);

}
