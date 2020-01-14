package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.MaritalStatusModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface MaritalStatusRepository extends JpaRepository<MaritalStatusModel, Long>{

	@Query("select m from MaritalStatusModel m where m.value = ?1")
	MaritalStatusModel findMaritalStatus(String maritalStatus);

}
