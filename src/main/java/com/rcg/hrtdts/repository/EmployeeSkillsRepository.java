package com.rcg.hrtdts.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
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

	@Query("select count(*) > 0 from EmployeeSkillsModel e where e.userHrtModel.eId = ?1") 
	boolean existsByEId(long geteId);

	@Modifying
	@Transactional
	@Query("delete from EmployeeSkillsModel e where e.userHrtModel.eId = ?1")
	int deleteByUserHrtModelEId(long eId);

}
