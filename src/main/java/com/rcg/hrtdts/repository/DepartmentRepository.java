package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.DepartmentModel;

/**
 * 
 * @author neena
 * @version 1.0
 * @since 2020-01-14
 * 
 **/
public interface DepartmentRepository extends JpaRepository<DepartmentModel, Long> {
	@Query("select s from DepartmentModel s where departmentId=?1")
	DepartmentModel getDepartmentDetails(Long departmentId);

}
