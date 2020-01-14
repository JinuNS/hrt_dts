package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.JobTypeModel;

public interface JobTypeRepository extends JpaRepository<JobTypeModel, Long>{

	@Query("select j from JobTypeModel j where j.value = ?1")
	JobTypeModel findJobType(String jobType);

}
