package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.EmployeeTypeModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeTypeRepository extends JpaRepository<EmployeeTypeModel, Long>{

	EmployeeTypeModel findByValue(String employeeType);

}
