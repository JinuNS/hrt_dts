package com.rcg.hrtdts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.rcg.hrtdts.model.SkillsModel;
/**
 * 
 * @author  neena
 * @version 1.0
 * @since   2020-01-14 
 * 
 **/
public interface SkillsModelrepository extends JpaRepository<SkillsModel, Long>{

	@Query("select s from SkillsModel s where s.id = ?1")
	SkillsModel findBySkillId(long skillId);

}
