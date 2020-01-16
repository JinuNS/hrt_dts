package com.rcg.hrtdts.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.EmployeeReferralModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface EmployeeReferralsRepository extends JpaRepository<EmployeeReferralModel, Long>{

	@Query("select e from EmployeeReferralModel e where e.userHrtModel.eId = ?1")
	EmployeeReferralModel findByEId(long id);
	
	@Query("select count(*) > 0 from EmployeeReferralModel e where e.userHrtModel.eId = ?1") 
	boolean existsByEId(long geteId);

	@Modifying
	@Transactional
	@Query("delete from EmployeeReferralModel e where e.userHrtModel.eId = ?1")
	void deleteByUserHrtModelEId(long geteId);

}
