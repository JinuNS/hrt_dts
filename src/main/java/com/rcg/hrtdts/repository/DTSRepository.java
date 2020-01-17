package com.rcg.hrtdts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.DTSModel;

public interface DTSRepository extends JpaRepository<DTSModel, Long>{

	@Query("SELECT id,dtsNo,projectName,projectManager.projectManagerId,workLocation FROM DTSModel")
	List<Object[]> getAllDtsInformation();

}
