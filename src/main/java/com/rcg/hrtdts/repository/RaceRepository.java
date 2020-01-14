package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.RaceModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface RaceRepository extends JpaRepository<RaceModel, Long>{

	@Query("select r from RaceModel r where r.value = ?1")
	RaceModel findRace(String race);

}
