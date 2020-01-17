package com.rcg.hrtdts.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.EmployeeTechnologyModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeTechnologyRepository extends JpaRepository<EmployeeTechnologyModel, Long>{
    
	@Query("select s from EmployeeTechnologyModel s where s.userHrtModel.eId = ?1")
	List<EmployeeTechnologyModel> findByEId(Long eId);

	@Query("select count(*) > 0 from EmployeeTechnologyModel e where e.userHrtModel.eId = ?1") 
	Boolean existsByEId(Long geteId);

	@Modifying
	@Transactional
	@Query("delete from EmployeeTechnologyModel e where e.userHrtModel.eId = ?1")
	int deleteByUserHrtModelEId(Long eId);

}
