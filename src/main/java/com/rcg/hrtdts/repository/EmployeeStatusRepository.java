package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rcg.hrtdts.model.EmployeeStatusModel;

public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatusModel, Long>{

	EmployeeStatusModel findByValue(String employeeType);

}
