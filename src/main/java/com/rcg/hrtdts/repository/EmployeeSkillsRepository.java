package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.EmployeeSkillsModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeSkillsRepository extends JpaRepository<EmployeeSkillsModel, Long>{
    
	@Query("select s from EmployeeSkillsModel s where s.userHrtModel.eId = ?1")
	List<EmployeeSkillsModel> findByEId(long eId);

}
