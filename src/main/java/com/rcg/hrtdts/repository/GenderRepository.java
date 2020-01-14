package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.GenderModel;

public interface GenderRepository extends JpaRepository<GenderModel, Long>{

	@Query("select g from GenderModel g where g.value = ?1")
	GenderModel findGender(String gender);

}
